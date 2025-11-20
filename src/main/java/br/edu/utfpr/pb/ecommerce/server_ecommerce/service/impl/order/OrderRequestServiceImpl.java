package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.order;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.client.brasilAPI.dto.AddressCEP;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.client.brasilAPI.service.CepService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.OrderNotFoundException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.PaymentNotFoundException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.ProductNotFoundException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.mapper.AddressMapper;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.*;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.OrderRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.PaymentRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.ProductRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.AuthService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrder.IOrderRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudRequestServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static br.edu.utfpr.pb.ecommerce.server_ecommerce.mapper.MapperUtils.map;
import static br.edu.utfpr.pb.ecommerce.server_ecommerce.util.ValidationUtils.validateQuantityOfProducts;

@Service
public class OrderRequestServiceImpl extends CrudRequestServiceImpl<Order, OrderUpdateDTO, Long> implements IOrderRequestService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final PaymentRepository paymentRepository;
    private final AuthService authService;
    private final ModelMapper modelMapper;
    private final CepService cepService;
    private final AddressMapper addressMapper;

    public OrderRequestServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, PaymentRepository paymentRepository, AuthService authService, ModelMapper modelMapper, CepService cepService, AddressMapper addressMapper) {
        super(orderRepository);
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.paymentRepository = paymentRepository;
        this.authService = authService;
        this.modelMapper = modelMapper;
        this.cepService = cepService;
        this.addressMapper = addressMapper;
    }

    private Order findAndValidateOrder(Long id, User user) {
        return orderRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new OrderNotFoundException("Order not found."));
    }

    private List<OrderItem> getOrderItems(Order order, List<OrderItemRequestDTO> orderItems) {
        List<Long> productIds = orderItems.stream()
                .map(OrderItemRequestDTO::getProductId)
                .distinct()
                .toList();

        Map<Long, Product> productMap = productRepository.findAllById(productIds).stream()
                .collect(Collectors.toMap(Product::getId, product -> product));

        return orderItems.stream()
                .map(itemDTO -> {
                    Product product = productMap.get(itemDTO.getProductId());
                    if (product == null) {
                        throw new ProductNotFoundException("Product not found with id: " + itemDTO.getProductId());
                    }

                    OrderItem item = new OrderItem();
                    item.setProduct(product);
                    validateQuantityOfProducts(itemDTO.getQuantity(), product);
                    item.setQuantity(itemDTO.getQuantity());
                    product.decreaseQuantity(itemDTO.getQuantity());

                    item.setOrder(order);

                    return item;
                }).toList();
    }

    @Override
    @Transactional
    public Order update(Long id, OrderUpdateDTO updateDTO) {
        User user = authService.getAuthenticatedUser();
        Order order = findAndValidateOrder(id, user);

        if(updateDTO.getAddress() != null) {
            EmbeddedAddress newAddress = map(updateDTO.getAddress(), EmbeddedAddress.class, modelMapper);
            order.setAddress(newAddress);
        }

        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order createOrder(OrderRequestDTO dto) {
        Order order = new Order();
        User user = authService.getAuthenticatedUser();
        order.setUser(user);

        AddressCEP addressCEP = cepService.getAddressByCEP(dto.getAddress().getCep());
        EmbeddedAddress embeddedAddress = addressMapper.toEmbeddedAddress(addressCEP, dto.getAddress());
        order.setAddress(embeddedAddress);

        List<OrderItem> itens = getOrderItems(order, dto.getOrderItems());

        order.setOrderItems(itens);

        Payment payment = paymentRepository.findById(dto.getPaymentId())
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found with this id: " + dto.getPaymentId()));

        order.setPayment(payment);

        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public void deleteAll() {
        User user = authService.getAuthenticatedUser();
        orderRepository.deleteAllByUser(user);
    }

    @Override
    @Transactional
    public void deleteById(Long aLong) {
        User user = authService.getAuthenticatedUser();
        orderRepository.deleteByIdAndUser(aLong, user);
    }

    @Override
    @Transactional
    public void delete(Iterable<? extends Order> iterable) {
        User user = authService.getAuthenticatedUser();
        orderRepository.deleteAllByUserAndIdIn(user, iterable);
    }
}

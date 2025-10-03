package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.order;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.*;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.OrderRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.ProductRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.AuthService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudRequestServiceImpl;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrder.IOrderRequestService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderRequestServiceImpl extends CrudRequestServiceImpl<Order, Long> implements IOrderRequestService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final AuthService authService;

    public OrderRequestServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, AuthService authService) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.authService = authService;
    }

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    @Override
    public Order createOrder(OrderRequestDTO dto) {
        Order order = new Order();
        User user = authService.getAuthenticatedUser();
        order.setUser(user);

        List<OrderItems> itens = dto.getOrderItems().stream().map(itemDTO -> {
            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("Product não encontrado"));

            OrderItems item = new OrderItems();
            item.setProduct(product);
            item.setQuantity(itemDTO.getQuantity());
            item.setOrder(order);

            return item;
        }).toList();

        order.setOrderItems(itens);

        return orderRepository.save(order);
    }

    @Override
    public void deleteAll() {
        User user = authService.getAuthenticatedUser();
        orderRepository.deleteAllByUser(user);
    }

    @Override
    public void deleteById(Long aLong) {
        User user = authService.getAuthenticatedUser();
        orderRepository.deleteByIdAndUser(aLong, user);
    }

    @Override
    public void delete(Iterable<? extends Order> iterable) {
        User user = authService.getAuthenticatedUser();
        orderRepository.deleteAllByUserAndIdIn(user, iterable);
    }
}

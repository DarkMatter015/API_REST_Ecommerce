package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.orderItem;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.OrderItemNotFoundException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.OrderNotFoundException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.ProductNotFoundException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.OrderItem;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Order;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Product;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.OrderItemsRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.OrderRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.ProductRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.AuthService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrderItems.IOrderItemsRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudRequestServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import static br.edu.utfpr.pb.ecommerce.server_ecommerce.util.ValidationUtils.validateQuantity;

@Service
public class OrderItemsRequestServiceImpl extends CrudRequestServiceImpl<OrderItem, Long> implements IOrderItemsRequestService {

    private final OrderItemsRepository orderItemsRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final AuthService authService;

    public OrderItemsRequestServiceImpl(OrderItemsRepository orderItemsRepository, ProductRepository productRepository, OrderRepository orderRepository, AuthService authService) {
        this.orderItemsRepository = orderItemsRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.authService = authService;
    }

    private OrderItem findAndValidateOrderItem(Long orderItemId) {
        User user = authService.getAuthenticatedUser();
        return orderItemsRepository.findByIdAndOrder_User_Id(orderItemId, user.getId())
                .orElseThrow(() -> new OrderItemNotFoundException("Order item not found or you don't have permission to access it."));
    }

    @Override
    protected JpaRepository getRepository() {
        return orderItemsRepository;
    }

    @Override
    public OrderItem createOrderItem(OrderItemRequestDTO dto) {
        User user = authService.getAuthenticatedUser();
        Order order = orderRepository.findByIdAndUser(dto.getOrderId(), user)
                .orElseThrow(() -> new OrderNotFoundException("Order not found."));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found."));

        OrderItem item = new OrderItem();
        item.setOrder(order);
        item.setProduct(product);

        validateQuantity(dto.getQuantity());
        item.setQuantity(dto.getQuantity());

        order.addItem(item);

        return orderItemsRepository.save(item);
    }

    @Override
    public OrderItem updateOrderItem(OrderItemUpdateDTO dto) {
        OrderItem item = findAndValidateOrderItem(dto.getId());

        validateQuantity(dto.getQuantity());
        item.setQuantity(dto.getQuantity());

        return orderItemsRepository.save(item);
    }

    @Override
    public void deleteOrderItem(Long id) {
        OrderItem item = findAndValidateOrderItem(id);

        Order order = item.getOrder();
        order.getOrderItems().remove(item);

        orderItemsRepository.delete(item);
    }
}

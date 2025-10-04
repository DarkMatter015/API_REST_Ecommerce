package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.orderItem;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItems.OrderItemsRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItems.OrderItemsUpdateDTO;
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
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new EntityNotFoundException("Order item not found or you don't have permission to access it."));
    }

    @Override
    protected JpaRepository getRepository() {
        return orderItemsRepository;
    }

    @Override
    public OrderItem createOrderItem(OrderItemsRequestDTO dto) {
        User user = authService.getAuthenticatedUser();
        Order order = orderRepository.findByIdAndUser(dto.getOrderId(), user)
                .orElseThrow(() -> new EntityNotFoundException("Order not found."));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found."));

        OrderItem item = new OrderItem();
        item.setOrder(order);
        item.setProduct(product);
        item.setQuantity(dto.getQuantity());

        order.addItem(item);

        return orderItemsRepository.save(item);
    }

    @Override
    public OrderItem updateOrderItem(OrderItemsUpdateDTO dto) {
        OrderItem item = findAndValidateOrderItem(dto.getId());

        if (dto.getQuantity() != null) {
            item.setQuantity(dto.getQuantity());
        }

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

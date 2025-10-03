package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.orderItems;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItems.OrderItemsRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItems.OrderItemsUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.OrderItems;
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

@Service
public class OrderItemsRequestServiceImpl extends CrudRequestServiceImpl<OrderItems, Long> implements IOrderItemsRequestService {

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

    @Override
    protected JpaRepository getRepository() {
        return orderItemsRepository;
    }

    public OrderItems adicionarItem(OrderItemsRequestDTO dto) {
        User user = authService.getAuthenticatedUser();
        Order order = orderRepository.findByIdAndUser(dto.getOrderId(), user)
                .orElseThrow(() -> new IllegalArgumentException("Order não encontrado"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product não encontrado"));

        OrderItems item = new OrderItems();
        item.setOrder(order);
        item.setProduct(product);
        item.setQuantity(dto.getQuantity());
        item.calculateTotalPrice();

        order.addItem(item);

        return orderItemsRepository.save(item);
    }

    public OrderItems atualizarItem(OrderItemsUpdateDTO dto) {
        User user = authService.getAuthenticatedUser();
        OrderItems item = orderItemsRepository.findByIdAndOrder_User_Id(dto.getId(), user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));

        if (dto.getQuantity() != null) {
            item.setQuantity(dto.getQuantity());
        }

        item.calculateTotalPrice();
        return orderItemsRepository.save(item);
    }

    public void deletarItem(Long id) {
        User user = authService.getAuthenticatedUser();
        OrderItems item = orderItemsRepository.findByIdAndOrder_User_Id(id, user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));

        Order order = item.getOrder();
        order.getOrderItems().remove(item);

        orderItemsRepository.delete(item);
    }
}

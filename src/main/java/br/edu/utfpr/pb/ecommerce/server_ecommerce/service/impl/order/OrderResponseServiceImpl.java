package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.order;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.product.ProductDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.OrderNotFoundException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Order;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.OrderRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.AuthService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrder.IOrderResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.edu.utfpr.pb.ecommerce.server_ecommerce.util.ValidationUtils.convertToDTOGeneric;

@Service
public class OrderResponseServiceImpl extends CrudResponseServiceImpl<Order, Long> implements IOrderResponseService {

    private final OrderRepository orderRepository;
    private final AuthService authService;

    public OrderResponseServiceImpl(OrderRepository orderRepository, AuthService authService) {
        this.orderRepository = orderRepository;
        this.authService = authService;
    }

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    @Override
    public OrderResponseDTO convertToDTO(Order orderSalvo, ModelMapper modelMapper) {
            OrderResponseDTO responseDTO = new OrderResponseDTO();
            responseDTO.setId(orderSalvo.getId());
            responseDTO.setUserId(orderSalvo.getUser().getId());

            List<OrderItemResponseDTO> itensResponse = orderSalvo.getOrderItems().stream()
                    .map(item -> {
                        OrderItemResponseDTO dto = new OrderItemResponseDTO();
                        dto.setId(item.getId());
                        ProductDTO productDTO = convertToDTOGeneric(item.getProduct(), ProductDTO.class, modelMapper);
                        dto.setProduct(productDTO);
                        dto.setQuantity(item.getQuantity());
                        dto.setTotalPrice(item.getTotalPrice());
                        return dto;
                    }).toList();

            responseDTO.setOrderItems(itensResponse);

            return responseDTO;
    }

    @Override
    public List<Order> findAll() {
        User user = authService.getAuthenticatedUser();
        return orderRepository.findAllByUser(user);
    }

    @Override
    public List<Order> findAll(Sort sort) {
        User user = authService.getAuthenticatedUser();
        return orderRepository.findAllByUser(user, sort);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        User user = authService.getAuthenticatedUser();
        return orderRepository.findAllByUser(user, pageable);
    }

    @Override
    public Order findById(Long id) {
        User user = authService.getAuthenticatedUser();
        return orderRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new OrderNotFoundException("Order not found."));
    }

    @Override
    public boolean exists(Long id) {
        User user = authService.getAuthenticatedUser();
        return orderRepository.existsByUserAndId(user, id);
    }

    @Override
    public long count() {
        User user = authService.getAuthenticatedUser();
        return orderRepository.countByUser(user);
    }
}

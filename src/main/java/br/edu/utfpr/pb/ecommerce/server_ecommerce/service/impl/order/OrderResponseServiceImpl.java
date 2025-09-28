package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.order;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItems.OrderItemsResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.product.ProductDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Order;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Order;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.OrderRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.UserRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrder.IOrderResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderResponseServiceImpl extends CrudResponseServiceImpl<Order, Long> implements IOrderResponseService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderResponseServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    @Override
    public OrderResponseDTO convertToDTO(Order orderSalvo, ModelMapper modelMapper) {
            // Converte para DTO de response
            OrderResponseDTO responseDTO = new OrderResponseDTO();
            responseDTO.setId(orderSalvo.getId());
            responseDTO.setUserId(orderSalvo.getUser().getId());

            List<OrderItemsResponseDTO> itensResponse = orderSalvo.getOrderItems().stream().map(item -> {
                OrderItemsResponseDTO dto = new OrderItemsResponseDTO();
                dto.setId(item.getId());
                ProductDTO productDTO = modelMapper.map(item.getProduct(), ProductDTO.class);
                dto.setProduct(productDTO);
                dto.setQuantity(item.getQuantity());
                dto.setTotalPrice(item.getTotalPrice());
                return dto;
            }).toList();

            responseDTO.setOrderItems(itensResponse);

            return responseDTO;
    }

    @Override
    public User getAuthenticatedUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findUsuarioByUsername(name);
    }

    @Override
    public List<Order> findAll() {
        User user = getAuthenticatedUser();
        return orderRepository.findAllByUser(user);
    }

    @Override
    public List<Order> findAll(Sort sort) {
        User user = getAuthenticatedUser();
        return orderRepository.findAllByUser(user, sort);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        User user = getAuthenticatedUser();
        return orderRepository.findAllByUser(user, pageable);
    }

    @Override
    public Order findById(Long id) {
        User user = getAuthenticatedUser();
        return orderRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado para este usuário"));
    }

    @Override
    public boolean exists(Long id) {
        User user = getAuthenticatedUser();
        return orderRepository.existsByUserAndId(user, id);
    }

    @Override
    public long count() {
        User user = getAuthenticatedUser();
        return orderRepository.countByUser(user);
    }
}

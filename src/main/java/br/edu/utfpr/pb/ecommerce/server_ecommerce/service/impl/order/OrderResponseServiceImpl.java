package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.order;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItems.OrderItemsResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.product.ProductDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Order;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.OrderRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrder.IOrderResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderResponseServiceImpl extends CrudResponseServiceImpl<Order, Long> implements IOrderResponseService {

    private final OrderRepository orderRepository;

    public OrderResponseServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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
}

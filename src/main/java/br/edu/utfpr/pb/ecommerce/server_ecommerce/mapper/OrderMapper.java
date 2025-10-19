package br.edu.utfpr.pb.ecommerce.server_ecommerce.mapper;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderItemMapper orderItemMapper;
    
    public OrderResponseDTO toDTO(Order order) {
        OrderResponseDTO responseDTO = new OrderResponseDTO();
        responseDTO.setId(order.getId());
        responseDTO.setData(order.getData());
        responseDTO.setUserId(order.getUser().getId());
        responseDTO.setAddress(order.getAddress());

        List<OrderItemResponseDTO> itensResponse = orderItemMapper.toDTOList(order.getOrderItems());

        responseDTO.setOrderItems(itensResponse);

        return responseDTO;
    }
    
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.mapper;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.payment.PaymentResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

import static br.edu.utfpr.pb.ecommerce.server_ecommerce.mapper.MapperUtils.map;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderItemMapper orderItemMapper;
    private final ModelMapper modelMapper;
    
    public OrderResponseDTO toDTO(Order order) {
        OrderResponseDTO responseDTO = new OrderResponseDTO();
        responseDTO.setId(order.getId());
        responseDTO.setData(order.getData());
        responseDTO.setUserId(order.getUser().getId());
        responseDTO.setAddress(order.getAddress());

        List<OrderItemResponseDTO> itensResponse = orderItemMapper.toDTOList(order.getOrderItems());
        responseDTO.setOrderItems(itensResponse);

        PaymentResponseDTO paymentResponseDTO = map(order.getPayment(), PaymentResponseDTO.class, modelMapper);
        responseDTO.setPayment(paymentResponseDTO);
        return responseDTO;
    }
    
}

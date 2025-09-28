package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrder;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Order;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudResponseService;
import org.modelmapper.ModelMapper;

public interface IOrderResponseService extends ICrudResponseService<Order, Long> {

    OrderResponseDTO convertToDTO(Order orderSalvo, ModelMapper modelMapper);
}

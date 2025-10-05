package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrderItems;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.OrderItem;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;

public interface IOrderItemsRequestService extends ICrudRequestService<OrderItem, Long> {
    OrderItem createOrderItem(OrderItemRequestDTO dto);
    OrderItem updateOrderItem(OrderItemUpdateDTO dto);
    void deleteOrderItem(Long id);
}

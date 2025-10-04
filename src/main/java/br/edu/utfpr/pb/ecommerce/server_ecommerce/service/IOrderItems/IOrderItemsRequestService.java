package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrderItems;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItems.OrderItemsRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItems.OrderItemsUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.OrderItem;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;

public interface IOrderItemsRequestService extends ICrudRequestService<OrderItem, Long> {
    OrderItem createOrderItem(OrderItemsRequestDTO dto);
    OrderItem updateOrderItem(OrderItemsUpdateDTO dto);
    void deleteOrderItem(Long id);
}

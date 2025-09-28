package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrder;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Order;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;

public interface IOrderRequestService extends ICrudRequestService<Order, Long> {
    Order createOrder(OrderRequestDTO dto);
    User getAuthenticatedUser();
}

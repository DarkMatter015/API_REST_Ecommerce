package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrderItems;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.OrderItems;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;

public interface IOrderItemsRequestService extends ICrudRequestService<OrderItems, Long> {
    User getAuthenticatedUser();
}

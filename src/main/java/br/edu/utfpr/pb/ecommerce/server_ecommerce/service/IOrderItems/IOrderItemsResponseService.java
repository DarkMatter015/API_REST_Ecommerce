package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrderItems;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.OrderItems;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudResponseService;

public interface IOrderItemsResponseService extends ICrudResponseService<OrderItems, Long> {
    User getAuthenticatedUser();
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.orderItems;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.ReadController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.OrderItem;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrderItems.IOrderItemsResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orderItems")
public class ReadOrderItemsController extends ReadController<OrderItem, OrderItemResponseDTO, Long> {
    private final IOrderItemsResponseService orderItemsResponseService;
    private final ModelMapper modelMapper;

    public ReadOrderItemsController(IOrderItemsResponseService orderItemsResponseService, ModelMapper modelMapper) {
        super(OrderItemResponseDTO.class);
        this.orderItemsResponseService = orderItemsResponseService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudResponseService<OrderItem, Long> getService() {
        return orderItemsResponseService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}

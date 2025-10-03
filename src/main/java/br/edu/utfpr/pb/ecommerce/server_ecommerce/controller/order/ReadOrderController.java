package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.order;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.ReadController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Order;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrder.IOrderResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class ReadOrderController extends ReadController<Order, OrderResponseDTO, Long> {
    private final IOrderResponseService orderResponseService;
    private final ModelMapper modelMapper;

    public ReadOrderController(IOrderResponseService orderResponseService, ModelMapper modelMapper) {
        super(OrderResponseDTO.class);
        this.orderResponseService = orderResponseService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudResponseService<Order, Long> getService() {
        return orderResponseService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}

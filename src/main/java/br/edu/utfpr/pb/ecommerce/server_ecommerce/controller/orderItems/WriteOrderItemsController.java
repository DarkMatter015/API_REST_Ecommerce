package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.orderItems;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.WriteController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.OrderItem;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.orderItem.OrderItemsRequestServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orderItems")
public class WriteOrderItemsController extends WriteController<OrderItem, OrderItemRequestDTO, OrderItemResponseDTO, OrderItemUpdateDTO, Long> {
    private final OrderItemsRequestServiceImpl orderItemsRequestService;

    public WriteOrderItemsController(OrderItemsRequestServiceImpl orderItemsRequestService, ModelMapper modelMapper) {
        super(orderItemsRequestService, modelMapper, OrderItem.class, OrderItemResponseDTO.class);
        this.orderItemsRequestService = orderItemsRequestService;
    }

    @Override
    public ResponseEntity<OrderItemResponseDTO> create(@RequestBody @Valid OrderItemRequestDTO dto) {
        OrderItem itemSalvo = orderItemsRequestService.createOrderItem(dto);
        OrderItemResponseDTO response = convertToResponseDto(itemSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}

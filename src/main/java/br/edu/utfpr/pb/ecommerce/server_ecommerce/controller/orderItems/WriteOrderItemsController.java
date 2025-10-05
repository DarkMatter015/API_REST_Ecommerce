package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.orderItems;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.OrderItem;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.orderItem.OrderItemsRequestServiceImpl;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.orderItem.OrderItemsResponseServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.edu.utfpr.pb.ecommerce.server_ecommerce.util.ValidationUtils.convertToDTOGeneric;

@RestController
@RequestMapping("orderItems")
public class WriteOrderItemsController {
    private final OrderItemsRequestServiceImpl orderItemsRequestService;
    private final OrderItemsResponseServiceImpl orderItemsResponseService;
    private final ModelMapper modelMapper;

    public WriteOrderItemsController(OrderItemsRequestServiceImpl orderItemsRequestService, OrderItemsResponseServiceImpl orderItemsResponseService, ModelMapper modelMapper) {
        this.orderItemsRequestService = orderItemsRequestService;
        this.orderItemsResponseService = orderItemsResponseService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<OrderItemResponseDTO> createOrderItem(@RequestBody @Valid OrderItemRequestDTO dto) {
        OrderItem itemSalvo = orderItemsRequestService.createOrderItem(dto);
        OrderItemResponseDTO response = convertToDTOGeneric(itemSalvo, OrderItemResponseDTO.class, modelMapper);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemResponseDTO> updateOrderItem(
            @PathVariable Long id,
            @RequestBody @Valid OrderItemUpdateDTO dto) {

        OrderItem item = orderItemsResponseService.findById(id);
        if (item == null) {
            return ResponseEntity.noContent().build();
        }

        dto.setId(id);
        OrderItem itemAtualizado = orderItemsRequestService.updateOrderItem(dto);
        OrderItemResponseDTO response = convertToDTOGeneric(itemAtualizado, OrderItemResponseDTO.class, modelMapper);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemsRequestService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }

}

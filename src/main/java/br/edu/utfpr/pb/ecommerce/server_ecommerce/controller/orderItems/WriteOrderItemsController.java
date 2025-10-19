package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.orderItems;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem.OrderItemUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.OrderItem;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.orderItem.OrderItemsRequestServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.edu.utfpr.pb.ecommerce.server_ecommerce.util.MapperUtils.map;

@RestController
@RequestMapping("orderItems")
public class WriteOrderItemsController {
    private final OrderItemsRequestServiceImpl orderItemsRequestService;
    private final ModelMapper modelMapper;

    public WriteOrderItemsController(OrderItemsRequestServiceImpl orderItemsRequestService, ModelMapper modelMapper) {
        this.orderItemsRequestService = orderItemsRequestService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<OrderItemResponseDTO> createOrderItem(@RequestBody @Valid OrderItemRequestDTO dto) {
        OrderItem itemSalvo = orderItemsRequestService.createOrderItem(dto);
        OrderItemResponseDTO response = map(itemSalvo, OrderItemResponseDTO.class, modelMapper);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderItemResponseDTO> updateOrder(@PathVariable Long id, @RequestBody @Valid OrderItemUpdateDTO updateDTO) {
        OrderItem orderItem = orderItemsRequestService.update(id, updateDTO);
        OrderItemResponseDTO orderItemResponseDTO = map(orderItem, OrderItemResponseDTO.class, modelMapper);

        return ResponseEntity.status(HttpStatus.OK).body(orderItemResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemsRequestService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

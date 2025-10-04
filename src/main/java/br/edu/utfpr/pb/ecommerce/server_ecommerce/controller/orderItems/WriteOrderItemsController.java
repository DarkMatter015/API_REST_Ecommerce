package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.orderItems;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItems.OrderItemsRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItems.OrderItemsResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItems.OrderItemsUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.OrderItem;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.orderItem.OrderItemsRequestServiceImpl;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.orderItem.OrderItemsResponseServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<OrderItemsResponseDTO> createOrderItem(@RequestBody @Valid OrderItemsRequestDTO dto) {
        OrderItem itemSalvo = orderItemsRequestService.createOrderItem(dto);
        OrderItemsResponseDTO response = modelMapper.map(itemSalvo, OrderItemsResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemsResponseDTO> updateOrderItem(
            @PathVariable Long id,
            @RequestBody @Valid OrderItemsUpdateDTO dto) {

        OrderItem item = orderItemsResponseService.findById(id);
        if (item == null) {
            return ResponseEntity.noContent().build();
        }

        dto.setId(id);
        OrderItem itemAtualizado = orderItemsRequestService.updateOrderItem(dto);
        OrderItemsResponseDTO response = modelMapper.map(itemAtualizado, OrderItemsResponseDTO.class);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemsRequestService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }

}

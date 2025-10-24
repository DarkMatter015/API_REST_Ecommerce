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
import org.springframework.web.bind.annotation.*;

import static br.edu.utfpr.pb.ecommerce.server_ecommerce.util.MapperUtils.map;

@RestController
@RequestMapping("orderItems")
public class WriteOrderItemsController extends WriteController<OrderItem, OrderItemRequestDTO, OrderItemResponseDTO, OrderItemUpdateDTO, Long> {
    private final OrderItemsRequestServiceImpl orderItemsRequestService;
    private final ModelMapper modelMapper;

    public WriteOrderItemsController(OrderItemsRequestServiceImpl orderItemsRequestService, ModelMapper modelMapper) {
        super(orderItemsRequestService, modelMapper, OrderItem.class, OrderItemResponseDTO.class);
        this.orderItemsRequestService = orderItemsRequestService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<OrderItemResponseDTO> create(@RequestBody @Valid OrderItemRequestDTO dto) {
        OrderItem itemSalvo = orderItemsRequestService.createOrderItem(dto);
        OrderItemResponseDTO response = map(itemSalvo, OrderItemResponseDTO.class, modelMapper);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<OrderItemResponseDTO> update(@PathVariable Long id, @RequestBody @Valid OrderItemUpdateDTO updateDto) {
        OrderItem orderItem = orderItemsRequestService.update(id, updateDto);
        OrderItemResponseDTO orderItemResponseDTO = map(orderItem, OrderItemResponseDTO.class, modelMapper);

        return ResponseEntity.status(HttpStatus.OK).body(orderItemResponseDTO);
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderItemsRequestService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.order;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.mapper.OrderMapper;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Order;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.order.OrderRequestServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class WriteOrderController {
    private final OrderRequestServiceImpl orderRequestService;
    private final OrderMapper orderMapper;

    public WriteOrderController(OrderRequestServiceImpl orderRequestService, OrderMapper orderMapper) {
        this.orderRequestService = orderRequestService;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody @Valid OrderRequestDTO orderDTO) {
        Order order = orderRequestService.createOrder(orderDTO);
        OrderResponseDTO responseDTO = orderMapper.toDTO(order);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderResponseDTO> updateOrder(@PathVariable Long id, @RequestBody @Valid OrderUpdateDTO updateDTO) {
        Order order = orderRequestService.update(id, updateDTO);
        OrderResponseDTO responseDTO = orderMapper.toDTO(order);

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}

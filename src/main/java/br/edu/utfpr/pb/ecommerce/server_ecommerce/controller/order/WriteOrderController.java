package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.order;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Order;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.order.OrderRequestServiceImpl;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.order.OrderResponseServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class WriteOrderController {
    private final OrderRequestServiceImpl pedidoRequestService;
    private final OrderResponseServiceImpl pedidoResponseService;
    private final ModelMapper modelMapper;

    public WriteOrderController(OrderRequestServiceImpl pedidoRequestService, OrderResponseServiceImpl pedidoResponseService, ModelMapper modelMapper){
        this.pedidoRequestService = pedidoRequestService;
        this.pedidoResponseService = pedidoResponseService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createPedido(@RequestBody @Valid OrderRequestDTO pedidoDTO) {
        Order orderSalvo = pedidoRequestService.createPedido(pedidoDTO);
        OrderResponseDTO responseDTO = pedidoResponseService.convertToDTO(orderSalvo, modelMapper);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}

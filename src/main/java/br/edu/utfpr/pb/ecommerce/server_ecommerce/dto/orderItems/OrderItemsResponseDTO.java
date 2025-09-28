package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItems;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsResponseDTO {

    private Long id;

    private Long orderId;

    private ProductDTO product;

    private BigDecimal totalPrice;

    private Integer quantity;
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemUpdateDTO {

    @Positive
    private Integer quantity;
}

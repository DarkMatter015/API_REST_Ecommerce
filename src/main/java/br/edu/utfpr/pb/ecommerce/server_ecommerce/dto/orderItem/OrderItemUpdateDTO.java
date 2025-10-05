package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.orderItem;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemUpdateDTO {

    @NotNull
    private Long id;

    @NotNull
    private Integer quantity;
}

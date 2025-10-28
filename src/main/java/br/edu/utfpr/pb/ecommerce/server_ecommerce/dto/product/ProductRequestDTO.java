package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

    @NotBlank
    @Size(min = 2, max = 255)
    private String name;

    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    private String urlImage;

    @NotNull
    @Min(value = 0, message = "The quantity of products cannot be negative")
    private Integer quantityAvailableInStock;

    @NotNull
    private Long categoryId;
}

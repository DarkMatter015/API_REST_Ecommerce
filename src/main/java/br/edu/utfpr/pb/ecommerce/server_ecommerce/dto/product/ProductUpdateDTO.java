package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateDTO {

    @Size(min = 2, max = 255)
    private String name;

    private String description;

    @Positive
    private BigDecimal price;

    private String urlImage;

    private List<String> images;

    @Min(value = 0, message = "The quantity of products cannot be negative")
    private Integer quantityAvailableInStock;

    private Long categoryId;
}

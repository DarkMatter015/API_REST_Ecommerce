package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.product;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 255)
    private String name;

    private String description;

    @NotNull
    private BigDecimal price;

    private String urlImage;

    @NotNull
    private Category category;
}

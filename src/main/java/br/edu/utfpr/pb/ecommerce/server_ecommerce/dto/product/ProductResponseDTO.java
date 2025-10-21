package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.product;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.category.CategoryResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private String urlImage;

    private CategoryResponseDTO category;
}

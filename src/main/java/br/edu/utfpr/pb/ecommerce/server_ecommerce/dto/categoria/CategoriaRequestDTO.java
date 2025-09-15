package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.categoria;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaRequestDTO {

    private Long id;

    @NotNull
    @Size(min = 4, max = 255)
    private String nome;
}

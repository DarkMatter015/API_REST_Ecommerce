package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaResponseDTO {

    private Long id;

    private String nome;
}

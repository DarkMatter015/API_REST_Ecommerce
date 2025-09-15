package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {
    private Long id;

    private String nome;

    private String email;
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.endereco;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Usuario;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    private int id;

    private Usuario usuario;

    @NotNull
    @Size(min = 3, max = 255)
    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;
}

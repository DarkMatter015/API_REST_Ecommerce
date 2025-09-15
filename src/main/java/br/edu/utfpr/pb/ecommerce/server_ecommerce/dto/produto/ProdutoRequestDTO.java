package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.produto;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Categoria;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequestDTO {

    private Long id;

    @NotNull
    @Size(min = 2, max = 255)
    private String nome;

    private String descricao;

    @NotNull
    private BigDecimal preco;

    private String urlImagem;

    private Categoria categoria;
}

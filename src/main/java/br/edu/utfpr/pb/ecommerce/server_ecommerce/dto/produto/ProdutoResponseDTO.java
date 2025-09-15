package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.produto;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponseDTO {

    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private String urlImagem;

    private Categoria categoria;
}

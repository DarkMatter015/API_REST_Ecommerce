package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.itensDoPedido;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Pedido;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItensDoPedidoRequestDTO {

    private Pedido pedido;

    private Produto produto;

    private BigDecimal preco;

    private int quantidade;
}

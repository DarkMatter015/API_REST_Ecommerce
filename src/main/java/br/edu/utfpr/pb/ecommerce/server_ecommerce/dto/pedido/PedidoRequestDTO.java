package br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.pedido;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequestDTO {

    private Long id;

    private Date data;

    private Usuario usuario;
}

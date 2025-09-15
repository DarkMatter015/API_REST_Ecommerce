package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Pedido;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.PedidoRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IPedidoResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoResponseServiceImpl extends CrudResponseServiceImpl<Pedido, Long> implements IPedidoResponseService {

    private final PedidoRepository pedidoRepository;

    public PedidoResponseServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    protected JpaRepository<Pedido, Long> getRepository() {
        return pedidoRepository;
    }
}

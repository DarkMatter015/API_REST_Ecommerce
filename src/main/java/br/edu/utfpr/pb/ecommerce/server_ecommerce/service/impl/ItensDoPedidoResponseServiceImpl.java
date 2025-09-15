package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.ItensDoPedido;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.ItensDoPedidoRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IItensDoPedidoResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ItensDoPedidoResponseServiceImpl extends CrudResponseServiceImpl<ItensDoPedido, Long> implements IItensDoPedidoResponseService {

    private final ItensDoPedidoRepository itensDoPedidoRepository;

    public ItensDoPedidoResponseServiceImpl(ItensDoPedidoRepository itensDoPedidoRepository) {
        this.itensDoPedidoRepository = itensDoPedidoRepository;
    }

    @Override
    protected JpaRepository<ItensDoPedido, Long> getRepository() {
        return itensDoPedidoRepository;
    }
}

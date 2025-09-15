package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Produto;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.ProdutoRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IProdutoResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoResponseServiceImpl extends CrudResponseServiceImpl<Produto, Long> implements IProdutoResponseService {

    private final ProdutoRepository produtoRepository;

    public ProdutoResponseServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    protected JpaRepository<Produto, Long> getRepository() {
        return produtoRepository;
    }
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Endereco;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.EnderecoRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IEnderecoResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoResponseServiceImpl extends CrudResponseServiceImpl<Endereco, Long> implements IEnderecoResponseService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoResponseServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    protected JpaRepository<Endereco, Long> getRepository() {
        return enderecoRepository;
    }
}

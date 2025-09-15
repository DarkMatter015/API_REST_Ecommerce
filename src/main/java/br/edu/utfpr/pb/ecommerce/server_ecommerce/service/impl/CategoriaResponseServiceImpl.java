package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Categoria;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.CategoriaRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICategoriaResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaResponseServiceImpl extends CrudResponseServiceImpl<Categoria, Long> implements ICategoriaResponseService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaResponseServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    protected JpaRepository<Categoria, Long> getRepository() {
        return categoriaRepository;
    }
}

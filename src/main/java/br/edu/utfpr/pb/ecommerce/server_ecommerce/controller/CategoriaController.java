package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.ResponseController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.categoria.CategoriaResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Categoria;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.CRUD.ICrudResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICategoriaResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("categorias")
public class CategoriaController extends ResponseController<Categoria, CategoriaResponseDTO, Long> {
    private final ICategoriaResponseService categoriaResponseService;
    private final ModelMapper modelMapper;

    public CategoriaController(ICategoriaResponseService categoriaResponseService, ModelMapper modelMapper) {
        super(CategoriaResponseDTO.class);
        this.categoriaResponseService = categoriaResponseService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudResponseService<Categoria, Long> getService() {
        return categoriaResponseService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}

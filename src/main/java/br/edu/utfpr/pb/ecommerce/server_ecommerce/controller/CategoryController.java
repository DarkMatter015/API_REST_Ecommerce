package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.ReadController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.category.CategoryDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Category;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.iCategory.ICategoryResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("categories")
public class CategoryController extends ReadController<Category, CategoryDTO, Long> {
    private final ICategoryResponseService categoriaResponseService;
    private final ModelMapper modelMapper;

    public CategoryController(ICategoryResponseService categoriaResponseService, ModelMapper modelMapper) {
        super(CategoryDTO.class);
        this.categoriaResponseService = categoriaResponseService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudResponseService<Category, Long> getService() {
        return categoriaResponseService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}

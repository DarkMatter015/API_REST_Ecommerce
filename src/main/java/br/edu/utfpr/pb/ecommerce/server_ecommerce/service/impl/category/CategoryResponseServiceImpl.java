package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.category;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Category;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.CategoryRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.iCategory.ICategoryResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryResponseServiceImpl extends CrudResponseServiceImpl<Category, Long> implements ICategoryResponseService {

    private final CategoryRepository categoryRepository;

    public CategoryResponseServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected JpaRepository<Category, Long> getRepository() {
        return categoryRepository;
    }
}

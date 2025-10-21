package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.product;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.product.ProductUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.CategoryNotFound;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.ProductNotFoundException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Category;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Product;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.CategoryRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.ProductRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IProduct.IProductRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudRequestServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.edu.utfpr.pb.ecommerce.server_ecommerce.util.ValidationUtils.validatePrice;
import static br.edu.utfpr.pb.ecommerce.server_ecommerce.util.ValidationUtils.validateStringNullOrBlank;

@Service
public class ProductRequestServiceImpl extends CrudRequestServiceImpl<Product, ProductUpdateDTO, Long> implements IProductRequestService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductRequestServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    @Transactional
    public Product update(Long id, ProductUpdateDTO updateDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found."));

        if (updateDTO.getName() != null) {
            validateStringNullOrBlank(updateDTO.getName());
            existingProduct.setName(updateDTO.getName());
        }

        if (updateDTO.getDescription() != null){
            validateStringNullOrBlank(updateDTO.getDescription());
            existingProduct.setDescription(updateDTO.getDescription());
        }

        if (updateDTO.getPrice() != null){
            validatePrice(updateDTO.getPrice());
            existingProduct.setPrice(updateDTO.getPrice());
        }

        if (updateDTO.getUrlImage() != null) {
            validateStringNullOrBlank(updateDTO.getUrlImage());
            existingProduct.setUrlImage(updateDTO.getUrlImage());
        }

        if (updateDTO.getCategoryId() != null){
            Category category = categoryRepository.findById(updateDTO.getCategoryId())
                    .orElseThrow(() -> new CategoryNotFound("Category not found with this id: " + updateDTO.getCategoryId()));

            existingProduct.setCategory(category);
        }

        return productRepository.save(existingProduct);
    }

}

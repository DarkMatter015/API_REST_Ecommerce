package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.product;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Product;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.ProductRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IProduct.IProductResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductResponseServiceImpl extends CrudResponseServiceImpl<Product, Long> implements IProductResponseService {

    public ProductResponseServiceImpl(ProductRepository productRepository) {
        super(productRepository);
    }

}

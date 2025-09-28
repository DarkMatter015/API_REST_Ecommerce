package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.ReadController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.product.ProductDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Product;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IProduct.IProductResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController extends ReadController<Product, ProductDTO, Long> {
    private final IProductResponseService productResponseService;
    private final ModelMapper modelMapper;

    public ProductController(IProductResponseService productResponseService, ModelMapper modelMapper) {
        super(ProductDTO.class);
        this.productResponseService = productResponseService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudResponseService<Product, Long> getService() {
        return productResponseService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}

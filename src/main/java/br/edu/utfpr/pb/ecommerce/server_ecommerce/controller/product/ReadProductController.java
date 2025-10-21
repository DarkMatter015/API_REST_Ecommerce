package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.product;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.ReadController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.product.ProductResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Product;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IProduct.IProductResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ReadProductController extends ReadController<Product, ProductResponseDTO, Long> {

    public ReadProductController(IProductResponseService productResponseService, ModelMapper modelMapper) {
        super(ProductResponseDTO.class, productResponseService, modelMapper);
    }
}

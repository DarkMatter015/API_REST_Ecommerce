package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.product;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.WriteController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.product.ProductRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.product.ProductResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.product.ProductUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.mapper.ProductMapper;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Product;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IProduct.IProductRequestService;
import jakarta.annotation.security.RolesAllowed;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@RolesAllowed("ADMIN")
public class WriteProductController extends WriteController<Product, ProductRequestDTO, ProductResponseDTO, ProductUpdateDTO, Long> {

    private final ProductMapper productMapper;

    public WriteProductController(IProductRequestService service, ModelMapper modelMapper, ProductMapper productMapper) {
        super(service, modelMapper, Product.class, ProductResponseDTO.class);
        this.productMapper = productMapper;
    }

    @Override
    protected Product convertToEntity(ProductRequestDTO createDto) {
        return productMapper.toEntity(createDto);
    }
}

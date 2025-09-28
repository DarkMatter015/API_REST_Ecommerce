package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.address;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.ReadController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address.AddressResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Address;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IAddress.IAddressResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("address")
public class ReadAddressController extends ReadController<Address, AddressResponseDTO, Long> {
    private final IAddressResponseService enderecoResponseService;
    private final ModelMapper modelMapper;

    public ReadAddressController(IAddressResponseService enderecoResponseService, ModelMapper modelMapper) {
        super(AddressResponseDTO.class);
        this.enderecoResponseService = enderecoResponseService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudResponseService<Address, Long> getService() {
        return enderecoResponseService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.address;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.WriteController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address.AddressRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address.AddressResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Address;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Order;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IAddress.IAddressRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IAddress.IAddressResponseService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class WriteAddressController extends WriteController<Address, AddressRequestDTO, AddressResponseDTO, Long> {
    private final IAddressRequestService enderecoRequestService;
    private final IAddressResponseService enderecoResponseService;
    private final ModelMapper modelMapper;

    public WriteAddressController(IAddressRequestService enderecoRequestService, IAddressResponseService enderecoResponseService, ModelMapper modelMapper) {
        super(Address.class, AddressRequestDTO.class, AddressResponseDTO.class);
        this.enderecoRequestService = enderecoRequestService;
        this.enderecoResponseService = enderecoResponseService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudRequestService<Address, Long> getService() {
        return enderecoRequestService;
    }

    @Override
    protected ICrudResponseService<Address, Long> getResponseService() {
        return enderecoResponseService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    public ResponseEntity<AddressResponseDTO> create(@RequestBody @Valid AddressRequestDTO address) {

        Address addressSalvo = enderecoRequestService.createAddres(address);
        AddressResponseDTO responseDTO = enderecoResponseService.convertToDTO(addressSalvo, modelMapper);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.address;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.WriteController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address.AddressRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address.AddressResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address.AddressUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Address;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IAddress.IAddressRequestService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.edu.utfpr.pb.ecommerce.server_ecommerce.mapper.MapperUtils.map;


@RestController
@RequestMapping("address")
public class WriteAddressController extends WriteController<Address, AddressRequestDTO, AddressResponseDTO, AddressUpdateDTO, Long> {
    private final IAddressRequestService  addressRequestService;
    private final ModelMapper modelMapper;

    public WriteAddressController(IAddressRequestService addressRequestService, ModelMapper modelMapper) {
        super(addressRequestService, modelMapper, Address.class, AddressResponseDTO.class);
        this.addressRequestService = addressRequestService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<AddressResponseDTO> create(@RequestBody @Valid AddressRequestDTO address) {
        Address addressSalvo = addressRequestService.createAddress(address);
        AddressResponseDTO responseDTO = map(addressSalvo, AddressResponseDTO.class, modelMapper);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IAddress;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address.AddressRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Address;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;

public interface IAddressRequestService extends ICrudRequestService<Address, Long> {
    Address createAddres(AddressRequestDTO addressDTO);
}

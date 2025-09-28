package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IAddress;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address.AddressResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.order.OrderResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Address;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Order;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudResponseService;
import org.modelmapper.ModelMapper;

public interface IAddressResponseService extends ICrudResponseService<Address, Long> {

    AddressResponseDTO convertToDTO(Address addressSalvo, ModelMapper modelMapper);

    User getAuthenticatedUser();
}

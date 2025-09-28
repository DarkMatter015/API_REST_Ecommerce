package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IUser;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address.AddressResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Address;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudResponseService;
import org.modelmapper.ModelMapper;

public interface IUserResponseService extends ICrudResponseService<User, Long> {
    UserResponseDTO convertToDTO(User user, ModelMapper modelMapper);
}

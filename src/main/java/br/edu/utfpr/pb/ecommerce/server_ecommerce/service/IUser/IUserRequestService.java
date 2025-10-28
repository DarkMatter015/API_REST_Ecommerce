package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IUser;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;

public interface IUserRequestService extends ICrudRequestService<User, UserUpdateDTO, Long> {
    User createUser(UserRequestDTO userRequestDTO);
}

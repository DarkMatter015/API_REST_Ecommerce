package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IUser;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;
import org.modelmapper.ModelMapper;

public interface IUserRequestService extends ICrudRequestService<User, Long> {

    User getAuthenticatedUser();

    User updateUser(Long aLong, UserRequestDTO entity, ModelMapper modelMapper);
    void deleteUser(Long aLong);
}

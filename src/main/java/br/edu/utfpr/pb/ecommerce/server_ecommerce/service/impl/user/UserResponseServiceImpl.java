package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.user;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.UserRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IUser.IUserResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserResponseServiceImpl extends CrudResponseServiceImpl<User, Long> implements IUserResponseService {

    private final UserRepository userRepository;

    public UserResponseServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public UserResponseDTO convertToDTO(User user, ModelMapper modelMapper) {
        UserResponseDTO responseDTO = modelMapper.map(user, UserResponseDTO.class);
        return responseDTO;
    }
}

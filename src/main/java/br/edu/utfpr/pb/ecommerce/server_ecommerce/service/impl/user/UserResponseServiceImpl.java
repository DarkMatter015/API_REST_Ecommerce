package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.user;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.UserRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IUser.IUserResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserResponseServiceImpl extends CrudResponseServiceImpl<User, Long> implements IUserResponseService {

    public UserResponseServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }

}

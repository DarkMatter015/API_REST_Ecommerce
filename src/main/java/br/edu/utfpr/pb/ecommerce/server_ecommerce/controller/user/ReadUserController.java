package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.user;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.ReadController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IUser.IUserResponseService;
import jakarta.annotation.security.RolesAllowed;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("users")
@RolesAllowed("ADMIN")
public class ReadUserController extends ReadController<User, UserResponseDTO, Long> {

    public ReadUserController(IUserResponseService service, ModelMapper modelMapper) {
        super(UserResponseDTO.class, service, modelMapper);
    }
}

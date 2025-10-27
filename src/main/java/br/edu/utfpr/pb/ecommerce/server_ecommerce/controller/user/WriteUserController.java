package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.user;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.WriteController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IUser.IUserRequestService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.edu.utfpr.pb.ecommerce.server_ecommerce.mapper.MapperUtils.map;


@RestController
@RequestMapping("users")
public class WriteUserController extends WriteController<User, UserRequestDTO, UserResponseDTO, UserUpdateDTO, Long> {

    private final IUserRequestService iUserRequestService;

    public WriteUserController(IUserRequestService userRequestService, ModelMapper modelMapper, IUserRequestService iUserRequestService) {
        super(userRequestService, modelMapper, User.class, UserResponseDTO.class);
        this.iUserRequestService = iUserRequestService;
    }

    @Override
    public ResponseEntity<UserResponseDTO> create(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        User user = iUserRequestService.createUser(userRequestDTO);
        UserResponseDTO responseDTO = map(user, UserResponseDTO.class, modelMapper);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Override
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO updateDTO) {
        User user = iUserRequestService.update(id, updateDTO);
        UserResponseDTO responseDTO = map(user, UserResponseDTO.class, modelMapper);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.WriteController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IUser.IUserRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IUser.IUserResponseService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController extends WriteController<User, UserRequestDTO, UserResponseDTO, Long> {
    private final IUserRequestService userRequestService;
    private final IUserResponseService userResponseService;
    private final ModelMapper modelMapper;

    public UserController(IUserRequestService userRequestService, IUserResponseService userResponseService, ModelMapper modelMapper) {
        super(User.class, UserRequestDTO.class, UserResponseDTO.class);
        this.userRequestService = userRequestService;
        this.userResponseService = userResponseService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudRequestService<User, Long> getService() {
        return userRequestService;
    }

    @Override
    protected ICrudResponseService<User, Long> getResponseService() {
        return userResponseService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody  @Valid UserRequestDTO entity) {
        User user = userRequestService.updateUser(id, entity, modelMapper);

        UserResponseDTO responseDTO = userResponseService.convertToDTO(user, modelMapper);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userRequestService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

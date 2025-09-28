package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.WriteController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address.AddressResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IUser.IUserRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IUser.IUserResponseService;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController extends WriteController<User, UserRequestDTO, UserResponseDTO, Long> {
    private final IUserRequestService usuarioRequestService;
    private final IUserResponseService usuarioResponseService;
    private final ModelMapper modelMapper;

    public UserController(IUserRequestService usuarioRequestService, IUserResponseService usuarioResponseService, ModelMapper modelMapper) {
        super(User.class, UserRequestDTO.class, UserResponseDTO.class);
        this.usuarioRequestService = usuarioRequestService;
        this.usuarioResponseService = usuarioResponseService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudRequestService<User, Long> getService() {
        return usuarioRequestService;
    }

    @Override
    protected ICrudResponseService<User, Long> getResponseService() {
        return usuarioResponseService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody  @Valid UserRequestDTO entity) {
        User user = usuarioRequestService.updateUser(id, entity, modelMapper);

        UserResponseDTO responseDTO = usuarioResponseService.convertToDTO(user, modelMapper);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioRequestService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

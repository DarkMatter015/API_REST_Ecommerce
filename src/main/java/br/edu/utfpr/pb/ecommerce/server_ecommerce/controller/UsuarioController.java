package br.edu.utfpr.pb.ecommerce.server_ecommerce.controller;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.controller.CRUD.RequestController;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.usuario.UsuarioRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Usuario;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.CRUD.ICrudRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.CRUD.ICrudResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.usuario.IUsuarioRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.usuario.IUsuarioResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController extends RequestController<Usuario, UsuarioRequestDTO, Long> {
    private final IUsuarioRequestService usuarioService;
    private final IUsuarioResponseService usuarioResponseService;
    private final ModelMapper modelMapper;

    public UsuarioController(IUsuarioRequestService usuarioService, IUsuarioResponseService usuarioResponseService, ModelMapper modelMapper) {
        super(Usuario.class, UsuarioRequestDTO.class);
        this.usuarioService = usuarioService;
        this.usuarioResponseService = usuarioResponseService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudRequestService<Usuario, Long> getService() {
        return usuarioService;
    }

    @Override
    protected ICrudResponseService<Usuario, Long> ICrudResponseService() {
        return usuarioResponseService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}

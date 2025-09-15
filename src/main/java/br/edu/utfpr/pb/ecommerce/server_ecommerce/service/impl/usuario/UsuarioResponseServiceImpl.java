package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.usuario;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Usuario;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.UsuarioRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.usuario.IUsuarioResponseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioResponseServiceImpl extends CrudResponseServiceImpl<Usuario, Long> implements IUsuarioResponseService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponseServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected JpaRepository<Usuario, Long> getRepository() {
        return usuarioRepository;
    }
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.usuario;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Usuario;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.UsuarioRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.usuario.IUsuarioRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudRequestServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioRequestServiceImpl extends CrudRequestServiceImpl<Usuario, Long> implements IUsuarioRequestService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioRequestServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    protected JpaRepository<Usuario, Long> getRepository() {
        return usuarioRepository;
    }

    @Override
    public Usuario save(Usuario entity) {
        entity.setSenha(bCryptPasswordEncoder.encode(entity.getSenha()));
        return super.save(entity);
    }

    @Override
    public Usuario saveAndFlush(Usuario entity) {
        entity.setSenha(bCryptPasswordEncoder.encode(entity.getSenha()));
        return super.saveAndFlush(entity);
    }

    @Override
    public Iterable<Usuario> save(Iterable<Usuario> iterable) {
        iterable.forEach(entity -> {
            entity.setSenha(bCryptPasswordEncoder.encode(entity.getSenha()));
        });
        return super.save(iterable);
    }
}

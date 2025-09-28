package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.user;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.UserRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IUser.IUserRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudRequestServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRequestServiceImpl extends CrudRequestServiceImpl<User, Long> implements IUserRequestService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRequestServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public User save(User entity) {
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        return super.save(entity);
    }

    @Override
    public User saveAndFlush(User entity) {
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        return super.saveAndFlush(entity);
    }

    @Override
    public Iterable<User> save(Iterable<User> iterable) {
        iterable.forEach(entity -> {
            entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        });
        return super.save(iterable);
    }

    @Override
    public User getAuthenticatedUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findUsuarioByUsername(name);
    }

    @Override
    public User updateUser(Long aLong, UserRequestDTO entity, ModelMapper modelMapper) {
        User authenticatedUser = getAuthenticatedUser();

        User existingUser = userRepository.findById(aLong)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if (!existingUser.getId().equals(authenticatedUser.getId())) {
            throw new RuntimeException("Usuário não autorizado.");
        }

        // Atualiza apenas os campos do DTO
        modelMapper.map(entity, existingUser);
        existingUser.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long aLong) {
        User authenticatedUser = getAuthenticatedUser();

        User existingUser = userRepository.findById(aLong)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if (!existingUser.getId().equals(authenticatedUser.getId())) {
            throw new RuntimeException("Usuário não autorizado.");
        }

        userRepository.delete(existingUser);
    }
}

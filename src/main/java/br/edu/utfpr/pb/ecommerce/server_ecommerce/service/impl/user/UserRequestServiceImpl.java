package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.user;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.user.UserUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.UserNotFoundException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.enums.Role;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.UserRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.AuthService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IUser.IUserRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudRequestServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.edu.utfpr.pb.ecommerce.server_ecommerce.util.ValidationUtils.validateStringNullOrBlank;


@Service
public class UserRequestServiceImpl extends CrudRequestServiceImpl<User, UserUpdateDTO, Long> implements IUserRequestService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthService authService;

    public UserRequestServiceImpl(UserRepository userRepository, AuthService authService) {
        this.userRepository = userRepository;
        this.authService = authService;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    private void encodePassword(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    }

    private User findAndValidateUser(Long id) {
        User authenticatedUser = authService.getAuthenticatedUser();

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found."));

        if (authenticatedUser.getRoles().contains(Role.ADMIN)){
            return existingUser;
        }

        if (!existingUser.getId().equals(authenticatedUser.getId())) {
            throw new AccessDeniedException("You don't have permission to modify this user.");
        }
        return existingUser;
    }

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    @Transactional
    public User save(User entity) {
        encodePassword(entity);
        return super.save(entity);
    }

    @Override
    @Transactional
    public User saveAndFlush(User entity) {
        encodePassword(entity);
        return super.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public Iterable<User> save(Iterable<User> iterable) {
        iterable.forEach(this::encodePassword);
        return super.save(iterable);
    }

    @Override
    @Transactional
    public User update(Long id, UserUpdateDTO dto) {
        User existingUser = findAndValidateUser(id);

        if (dto.getDisplayName() != null) {
            validateStringNullOrBlank(dto.getDisplayName());
            existingUser.setDisplayName(dto.getDisplayName());
        }

        if (dto.getPassword() != null) {
            validateStringNullOrBlank(dto.getPassword());
            existingUser.setPassword(dto.getPassword());
            encodePassword(existingUser);
        }
        return userRepository.save(existingUser);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        User existingUser = findAndValidateUser(id);
        userRepository.delete(existingUser);
    }

    @Override
    @Transactional
    public void deleteAll() {
        super.deleteAll();
    }

    @Override
    @Transactional
    public void delete(Iterable<? extends User> iterable) {
        super.delete(iterable);
    }
}

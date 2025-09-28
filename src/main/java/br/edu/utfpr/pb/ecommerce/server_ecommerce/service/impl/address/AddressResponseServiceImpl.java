package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.address;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address.AddressResponseDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Address;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.AddressRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.UserRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IAddress.IAddressResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressResponseServiceImpl extends CrudResponseServiceImpl<Address, Long> implements IAddressResponseService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressResponseServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }


    @Override
    public AddressResponseDTO convertToDTO(Address addressSalvo, ModelMapper modelMapper) {
        AddressResponseDTO responseDTO = modelMapper.map(addressSalvo, AddressResponseDTO.class);
        return responseDTO;
    }

    @Override
    public User getAuthenticatedUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findUsuarioByUsername(name);
    }


    @Override
    public List<Address> findAll() {
        User user = getAuthenticatedUser();
        return addressRepository.findAllByUser(user);
    }

    @Override
    public List<Address> findAll(Sort sort) {
        User user = getAuthenticatedUser();
        return addressRepository.findAllByUser(user, sort);
    }

    @Override
    public Page<Address> findAll(Pageable pageable) {
        User user = getAuthenticatedUser();
        return addressRepository.findAllByUser(user, pageable);
    }

    @Override
    public Address findById(Long id) {
        User user = getAuthenticatedUser();
        return addressRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado para este usuário"));
    }

    @Override
    public boolean exists(Long id) {
        User user = getAuthenticatedUser();
        return addressRepository.existsByUserAndId(user, id);
    }

    @Override
    public long count() {
        User user = getAuthenticatedUser();
        return addressRepository.countByUser(user);
    }
}

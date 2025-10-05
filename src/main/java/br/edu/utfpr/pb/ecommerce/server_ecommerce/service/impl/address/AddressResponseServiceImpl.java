package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.address;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.exception.AddressNotFoundException;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Address;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.AddressRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.AuthService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IAddress.IAddressResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressResponseServiceImpl extends CrudResponseServiceImpl<Address, Long> implements IAddressResponseService {

    private final AddressRepository addressRepository;
    private final AuthService authService;

    public AddressResponseServiceImpl(AddressRepository addressRepository, AuthService authService) {
        this.addressRepository = addressRepository;
        this.authService = authService;
    }

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    @Override
    public List<Address> findAll() {
        User user = authService.getAuthenticatedUser();
        return addressRepository.findAllByUser(user);
    }

    @Override
    public List<Address> findAll(Sort sort) {
        User user = authService.getAuthenticatedUser();
        return addressRepository.findAllByUser(user, sort);
    }

    @Override
    public Page<Address> findAll(Pageable pageable) {
        User user = authService.getAuthenticatedUser();
        return addressRepository.findAllByUser(user, pageable);
    }

    @Override
    public Address findById(Long id) {
        User user = authService.getAuthenticatedUser();
        return addressRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new AddressNotFoundException("Address not found."));
    }

    @Override
    public boolean exists(Long id) {
        User user = authService.getAuthenticatedUser();
        return addressRepository.existsByUserAndId(user, id);
    }

    @Override
    public long count() {
        User user = authService.getAuthenticatedUser();
        return addressRepository.countByUser(user);
    }
}

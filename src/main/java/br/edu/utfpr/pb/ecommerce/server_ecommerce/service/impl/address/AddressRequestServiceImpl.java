package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.address;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address.AddressRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Address;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.AddressRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.AuthService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IAddress.IAddressRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudRequestServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AddressRequestServiceImpl extends CrudRequestServiceImpl<Address, Long> implements IAddressRequestService {

    private final AddressRepository addressRepository;
    private final AuthService  authService;

    public AddressRequestServiceImpl(AddressRepository addressRepository, AuthService authService) {
        this.addressRepository = addressRepository;
        this.authService = authService;
    }

    private void validateAddressOwnership(Address address) {
        User user = authService.getAuthenticatedUser();
        if (!address.getUser().getId().equals(user.getId())) {
            throw new AccessDeniedException("You don't have permission to modify this address!");
        }
    }

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    @Override
    public Address createAddress(AddressRequestDTO addressDTO) {
        Address address = new Address();

        User user = authService.getAuthenticatedUser();
        address.setUser(user);
        address.setStreet(addressDTO.getStreet());
        address.setNumber(addressDTO.getNumber());
        address.setComplement(addressDTO.getComplement());
        address.setNeighborhood(addressDTO.getNeighborhood());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setCep(addressDTO.getCep());

        return super.save(address);
    }

    @Override
    public Address save(Address address) {
        validateAddressOwnership(address);
        return super.save(address);
    }

    @Override
    public Iterable<Address> save(Iterable<Address> iterable) {
        StreamSupport.stream(iterable.spliterator(), false)
                .forEach(this::validateAddressOwnership);
        return super.save(iterable);
    }

    @Override
    public Address saveAndFlush(Address address) {
        validateAddressOwnership(address);
        return super.saveAndFlush(address);
    }

    @Override
    public void deleteAll() {
        User user = authService.getAuthenticatedUser();
        addressRepository.deleteAllByUser(user);
    }

    @Override
    public void deleteById(Long aLong) {
        User user = authService.getAuthenticatedUser();
        addressRepository.deleteByIdAndUser(aLong, user);
    }

    @Override
    public void delete(Iterable<? extends Address> iterable) {
        User user = authService.getAuthenticatedUser();
        List<Long> addressIds = StreamSupport.stream(iterable.spliterator(), false)
                .map(Address::getId)
                .collect(Collectors.toList());
        addressRepository.deleteAllByIdInAndUser(addressIds, user);
    }
}

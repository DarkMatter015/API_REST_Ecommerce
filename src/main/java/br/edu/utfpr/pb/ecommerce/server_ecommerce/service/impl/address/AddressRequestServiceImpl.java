package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.address;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.address.AddressRequestDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Address;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.AddressRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.AuthService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IAddress.IAddressRequestService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudRequestServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressRequestServiceImpl extends CrudRequestServiceImpl<Address, Long> implements IAddressRequestService {

    private final AddressRepository addressRepository;
    private final AuthService  authService;

    public AddressRequestServiceImpl(AddressRepository addressRepository, AuthService authService) {
        this.addressRepository = addressRepository;
        this.authService = authService;
    }

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    public Address createAddres(AddressRequestDTO addressDTO) {
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
        addressRepository.deleteAllByUserAndIdIn(user, iterable);
    }
}

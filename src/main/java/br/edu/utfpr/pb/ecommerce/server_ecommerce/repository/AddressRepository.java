package br.edu.utfpr.pb.ecommerce.server_ecommerce.repository;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Address;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Long> {
    List<Address> findAllByUser(User user);
    Optional<Address> findByIdAndUser(Long id, User user);
    List<Address> findAllByUser(User user, Sort sort);
    Page<Address> findAllByUser(User user, Pageable pageable);
    boolean existsByUserAndId(User user, Long id);
    long countByUser(User user);

    void deleteAllByUser(User user);
    void deleteByIdAndUser(Long id, User user);
    void deleteAllByUserAndIdIn(User user, Iterable<? extends Address> ids);
}

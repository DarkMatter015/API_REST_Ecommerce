package br.edu.utfpr.pb.ecommerce.server_ecommerce.repository;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.OrderItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemsRepository extends JpaRepository<OrderItems,Long> {
    List<OrderItems> findAllByOrder_User_Id(Long orderUserId);

    Optional<OrderItems> findByIdAndOrder_User_Id(Long id, Long orderUserId);
    List<OrderItems> findAllByOrder_User_Id(Long orderUserId, Sort sort);

    Page<OrderItems> findAllByOrder_User_Id(Long orderUserId, Pageable pageable);
    boolean existsByOrder_User_IdAndId(Long orderUserId, Long id);

    long countByOrder_User_Id(Long orderUserId);
    
}

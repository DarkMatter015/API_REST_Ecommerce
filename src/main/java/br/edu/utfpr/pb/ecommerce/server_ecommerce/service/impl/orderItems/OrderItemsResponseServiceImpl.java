package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.orderItems;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.OrderItems;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.User;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.repository.OrderItemsRepository;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.AuthService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IOrderItems.IOrderItemsResponseService;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD.CrudResponseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsResponseServiceImpl extends CrudResponseServiceImpl<OrderItems, Long> implements IOrderItemsResponseService {

    private final OrderItemsRepository orderItemsRepository;
    private final AuthService authService;

    public OrderItemsResponseServiceImpl(OrderItemsRepository orderItemsRepository, AuthService authService) {
        this.orderItemsRepository = orderItemsRepository;
        this.authService = authService;
    }

    @Override
    protected JpaRepository<OrderItems, Long> getRepository() {
        return orderItemsRepository;
    }

    @Override
    public List<OrderItems> findAll() {
        User user = authService.getAuthenticatedUser();
        return orderItemsRepository.findAllByOrder_User_Id(user.getId());
    }

    @Override
    public List<OrderItems> findAll(Sort sort) {
        User user = authService.getAuthenticatedUser();
        return orderItemsRepository.findAllByOrder_User_Id(user.getId(), sort);
    }

    @Override
    public Page<OrderItems> findAll(Pageable pageable) {
        User user = authService.getAuthenticatedUser();
        return orderItemsRepository.findAllByOrder_User_Id(user.getId(), pageable);
    }

    @Override
    public OrderItems findById(Long id) {
        User user = authService.getAuthenticatedUser();
        return orderItemsRepository.findByIdAndOrder_User_Id(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado para este usuário"));
    }

    @Override
    public boolean exists(Long id) {
        User user = authService.getAuthenticatedUser();
        return orderItemsRepository.existsByOrder_User_IdAndId(user.getId(), id);
    }

    @Override
    public long count() {
        User user = authService.getAuthenticatedUser();
        return orderItemsRepository.countByOrder_User_Id(user.getId());
    }
}

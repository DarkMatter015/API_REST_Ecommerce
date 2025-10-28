package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

public abstract class CrudRequestServiceImpl<T, UD, ID extends Serializable> implements ICrudRequestService<T, UD, ID> {

    private final JpaRepository<T, ID> repository;
    
    public CrudRequestServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }
    
    @Override
    @Transactional
    public T save(T entity) {
        return this.repository.save(entity);
    }

    @Override
    @Transactional
    public T saveAndFlush(T entity) {
        return this.repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public Iterable<T> save(Iterable<T> iterable) {
        return this.repository.saveAll(iterable);
    }

    @Override
    @Transactional
    public abstract T update(ID id, UD updateDTO);

    @Override
    @Transactional
    public void deleteById(ID id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(Iterable<? extends T> iterable) {
        this.repository.deleteAll(iterable);
    }

    @Override
    @Transactional
    public void deleteAll() {
        this.repository.deleteAll();
    }
}

package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudResponseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class CrudResponseServiceImpl<T, ID extends Serializable> implements ICrudResponseService<T, ID> {

    private final JpaRepository<T, ID> repository;

    protected CrudResponseServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return this.repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll(Sort sort) {
        return this.repository.findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<T> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    @Transactional
    public void flush() {
        this.repository.flush();
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(ID id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with ID: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(ID id) {
        return this.repository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return this.repository.count();
    }
}

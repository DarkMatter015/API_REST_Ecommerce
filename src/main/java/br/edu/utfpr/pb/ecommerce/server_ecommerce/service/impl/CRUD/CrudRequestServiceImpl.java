package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.impl.CRUD;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

public abstract class CrudRequestServiceImpl<T, UD, ID extends Serializable> implements ICrudRequestService<T, UD, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    @Transactional
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    @Transactional
    public T saveAndFlush(T entity) {
        return getRepository().saveAndFlush(entity);
    }

    @Override
    @Transactional
    public Iterable<T> save(Iterable<T> iterable) {
        return getRepository().saveAll(iterable);
    }

    @Override
    @Transactional
    public abstract T update(ID id, UD updateDTO);

    @Override
    @Transactional
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    @Transactional
    public void delete(Iterable<? extends T> iterable) {
        getRepository().deleteAll(iterable);
    }

    @Override
    @Transactional
    public void deleteAll() {
        getRepository().deleteAll();
    }
}

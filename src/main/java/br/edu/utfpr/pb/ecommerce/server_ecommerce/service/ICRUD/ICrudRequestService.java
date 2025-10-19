package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD;

import java.io.Serializable;

public interface ICrudRequestService<T, UD, ID extends Serializable>{
    T save(T entity);

    T saveAndFlush(T entity);

    Iterable<T> save(Iterable<T> iterable);

    T update(ID id, UD updateDTO);

    void deleteById(ID id);

    void delete(Iterable<? extends T> iterable);

    void deleteAll();
}

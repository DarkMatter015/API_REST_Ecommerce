package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.CRUD;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

public interface ICrudResponseService<T, ID extends Serializable> {

    List<T> findAll();

    List<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);

    void flush();

    T findById(ID id);

    boolean exists(ID id);

    long count();
}

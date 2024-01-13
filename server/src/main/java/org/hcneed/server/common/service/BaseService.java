package org.hcneed.server.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {
    T findById(ID id);
    List<T> findAll();
    Page<T> findAll(Pageable pageable);
    T save(T t);
    void saveAll(Iterable<T> list);
    void delete(ID id);
}

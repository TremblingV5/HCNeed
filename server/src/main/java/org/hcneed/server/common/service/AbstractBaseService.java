package org.hcneed.server.common.service;

import org.hcneed.server.common.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractBaseService<T, ID extends Serializable, Repository extends BaseRepository<T, ID>> implements BaseService<T, ID> {
    @Autowired
    Repository repository;

    public T findById(ID id) {
        return repository.findById(id).orElse(null);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public T save(T t) {
        repository.save(t);
        return t;
    }

    public void saveAll(Iterable<T> list) {
        repository.saveAll(list);
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }
}

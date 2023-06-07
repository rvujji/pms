package com.xinthe.pms.service.impl;

import com.xinthe.pms.repository.GenericRepository;
import com.xinthe.pms.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

    @Autowired
    private final GenericRepository<T, ID> repository;

    public GenericServiceImpl(GenericRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public T getById(ID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T update(ID id, T entity) {
        T existingEntity = repository.findById(id).orElse(null);
        if (existingEntity != null) {
            // Perform necessary updates on the existingEntity using the entity parameter
            // ...
            return repository.save(existingEntity);
        }
        return null;
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}



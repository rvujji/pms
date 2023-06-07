package com.xinthe.pms.service;

import com.xinthe.pms.model.Project;

import java.util.List;

import org.springframework.stereotype.Service;
import java.util.List;

public interface GenericService<T, ID> {
    T create(T entity);
    T getById(ID id);
    List<T> getAll();
    T update(ID id, T entity);
    void delete(ID id);
}

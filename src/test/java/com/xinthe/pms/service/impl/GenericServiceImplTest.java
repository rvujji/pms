package com.xinthe.pms.service.impl;

import com.xinthe.pms.repository.GenericRepository;
import com.xinthe.pms.service.GenericService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GenericServiceImplTest {

    @Mock
    GenericRepository<Integer, Integer> mockRepository;

    GenericService<Integer, Integer> service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new GenericServiceImpl<>(mockRepository);
    }

    @Test
    void testCreate() {
        Integer entity = 123;

        Mockito.when(mockRepository.save(entity)).thenReturn(entity);

        Integer result = service.create(entity);

        Assertions.assertEquals(entity, result);
        Mockito.verify(mockRepository, Mockito.times(1)).save(entity);
    }

    @Test
    void testGetById() {
        Integer id = 1;
        Integer entity = 123;

        Mockito.when(mockRepository.findById(id)).thenReturn(Optional.of(entity));

        Integer result = service.getById(id);

        Assertions.assertEquals(entity, result);
        Mockito.verify(mockRepository, Mockito.times(1)).findById(id);
    }

    @Test
    void testGetAll() {
        List<Integer> entities = new ArrayList<>();
        entities.add(123);
        entities.add(456);

        Mockito.when(mockRepository.findAll()).thenReturn(entities);

        List<Integer> result = service.getAll();

        Assertions.assertEquals(entities, result);
        Mockito.verify(mockRepository, Mockito.times(1)).findAll();
    }

    @Test
    void testUpdate() {
        Integer id = 1;
        Integer entity = 123;
        Integer updatedEntity = 456;

        Mockito.when(mockRepository.findById(id)).thenReturn(Optional.of(entity));
        Mockito.when(mockRepository.save(entity)).thenReturn(updatedEntity);

        Integer result = service.update(id, updatedEntity);

        Assertions.assertEquals(updatedEntity, result);
        Mockito.verify(mockRepository, Mockito.times(1)).findById(id);
        Mockito.verify(mockRepository, Mockito.times(1)).save(entity);
    }

    @Test
    void testDelete() {
        Integer id = 1;

        service.delete(id);

        Mockito.verify(mockRepository, Mockito.times(1)).deleteById(id);
    }
}
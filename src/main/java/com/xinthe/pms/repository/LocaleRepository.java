package com.xinthe.pms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LocaleRepository<T, ID> extends GenericRepository<T, ID> {
    // Add custom repository methods if needed
}


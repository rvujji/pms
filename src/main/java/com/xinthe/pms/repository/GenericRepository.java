package com.xinthe.pms.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
@Component
public interface GenericRepository<T, ID> extends MongoRepository<T, ID> {
    // Add custom repository methods if needed
}


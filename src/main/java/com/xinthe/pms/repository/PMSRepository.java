package com.xinthe.pms.repository;

import com.xinthe.pms.model.PmsCollection;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PMSRepository extends MongoRepository<PmsCollection, String> {

}

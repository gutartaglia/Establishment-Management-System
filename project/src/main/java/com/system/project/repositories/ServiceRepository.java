package com.system.project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.system.project.domain.Service;

public interface ServiceRepository extends MongoRepository<Service, String>{
    
}

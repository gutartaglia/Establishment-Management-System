package com.system.project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.system.project.domain.Establishment;


public interface EstablishmentRepository extends MongoRepository<Establishment, String>{

    boolean existsByEmail(String email);
    
    boolean existsByEmailAndIdNot(String email, String id);
}

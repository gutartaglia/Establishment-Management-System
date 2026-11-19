package com.system.project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.system.project.domain.Professional;
import java.util.List;


public interface ProfessionalRepository extends MongoRepository<Professional, String>{
    
    boolean existsByEmail(String email);

    List<Professional> findByEstablishmentId(String establishmentId);

    boolean existsByEmailAndIdNot(String email, String id);
}

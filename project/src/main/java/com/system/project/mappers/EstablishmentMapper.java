package com.system.project.mappers;

import org.springframework.stereotype.Component;

import com.system.project.domain.Establishment;
import com.system.project.dto.request.EstablishmentRequest;
import com.system.project.dto.response.EstablishmentResponse;

@Component 
public class EstablishmentMapper {
    
    public Establishment toEntity(EstablishmentRequest request){
        return new Establishment(
            request.getName(), 
            request.getDescription(), 
            request.getEmail(), 
            request.getPhone(), 
            request.getAddress());
    }

    public EstablishmentResponse toResponse(Establishment establishment){
        return new EstablishmentResponse (
        establishment.getId(), 
        establishment.getName(), 
        establishment.getDescription(), 
        establishment.getEmail(), 
        establishment.getPhone(), 
        establishment.getAddress(), 
        establishment.isActive(), 
        establishment.getCreatedAt());
    }

}

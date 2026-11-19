package com.system.project.mappers;

import org.springframework.stereotype.Component;

import com.system.project.domain.Professional;
import com.system.project.dto.request.ProfessionalRequest;
import com.system.project.dto.response.ProfessionalResponse;

@Component 
public class ProfessionalMapper {
    
    public Professional toEntity(ProfessionalRequest request){
        return new Professional(
            request.getName(), 
            request.getEmail(), 
            request.getPhone(), 
            request.getEstablishmentId()
        );
    }

    public ProfessionalResponse toResponse(Professional professional){
        return new ProfessionalResponse(
            professional.getId(), 
            professional.getName(), 
            professional.getEmail(), 
            professional.getPhone(), 
            professional.isActive(), 
            professional.getEstablishmentId()
        );
    }

    public void updateProfessional(ProfessionalRequest request, Professional professional){
        professional.setName(request.getName());
        professional.setEmail(request.getEmail());
        professional.setPhone(request.getPhone());
        professional.setEstablishmentId(request.getEstablishmentId());
    }

}

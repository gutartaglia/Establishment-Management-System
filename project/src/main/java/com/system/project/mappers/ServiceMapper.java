package com.system.project.mappers;

import org.springframework.stereotype.Component;

import com.system.project.domain.Service;
import com.system.project.dto.request.ServiceRequest;
import com.system.project.dto.response.ServiceResponse;

@Component 
public class ServiceMapper {
    
    public Service toEntity(ServiceRequest request){
        return new Service(
            request.getName(), 
            request.getDescription(), 
            request.getPrice(), 
            request.getDurationMinutes(), 
            request.getEstablishmentId());
    }

    public ServiceResponse toResponse(Service service){
        return new ServiceResponse(
            service.getId(), 
            service.getName(), 
            service.getDescription(), 
            service.getPrice(), 
            service.getDurationMinutes(),
            service.getEstablishmentId()
        );
    }

    

}

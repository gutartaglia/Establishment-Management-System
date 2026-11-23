package com.system.project.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor
public class ServiceRequest {
    
    private String name;
    private String description;
    private BigDecimal price;
    private Integer durationMinutes;
    private String establishmentId;

    public ServiceRequest(String name, BigDecimal price, Integer durationMinutes, String establishmentId){
        this.name = name;
        this.price = price;
        this.durationMinutes = durationMinutes;
        this.establishmentId = establishmentId;
    }

}

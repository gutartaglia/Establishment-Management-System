package com.system.project.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
public class ServiceResponse {
    
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer durationMinutes;
    private String establishmentId;

    public ServiceResponse(String id, String name, BigDecimal price, Integer durationMinutes, String establishmentId){
        this.id = id;
        this.name = name;
        this.price = price;
        this.durationMinutes = durationMinutes;
        this.establishmentId = establishmentId;
    }

}

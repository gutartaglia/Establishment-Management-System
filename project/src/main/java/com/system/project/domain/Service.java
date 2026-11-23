package com.system.project.domain;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@EqualsAndHashCode 
@Document(collection = "services")
public class Service {
    
    @Id 
    private String id;

    @NotBlank 
    private String name;
    
    private String description;

    @NotBlank 
    private BigDecimal price;

    @NotBlank 
    private Integer durationMinutes;

    private Boolean active = true;

    @NotBlank 
    private String establishmentId;

    public Service(String name, String description, BigDecimal price, Integer durationMinutes, String establishmentId){
        this.name = name;
        this.description = description;
        this.price = price;
        this.durationMinutes = durationMinutes;
        this.establishmentId = establishmentId;
    }

    public Service(String name, BigDecimal price, Integer durationMinutes, String establishmentId){
        this.name = name;
        this.price = price;
        this.durationMinutes = durationMinutes;
        this.establishmentId = establishmentId;
    }

}

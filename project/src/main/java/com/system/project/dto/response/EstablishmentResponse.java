package com.system.project.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
public class EstablishmentResponse {
    
    private String id;
    private String name;
    private String description;
    private String email;
    private String phone;
    private String address;
    private boolean active; 
    private LocalDateTime createdAt;


}

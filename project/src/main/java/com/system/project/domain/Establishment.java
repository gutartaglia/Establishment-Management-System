package com.system.project.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
@EqualsAndHashCode  
@Document(collection = "establishments")
public class Establishment {
    

    @Id 
    private String id;

    @NotBlank 
    private String name;

    private String description;

    @Email 
    @NotBlank 
    private String email;

    @NotBlank 
    private String phone;

    @NotBlank 
    private String address;

    private boolean active = true; 
    private LocalDateTime createdAt;

    private List<Professional> professionals = new ArrayList<>();

    public Establishment(String name, String description, String email, String phone, String address){
        this.name = name;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.createdAt = LocalDateTime.now();
    }

    public Establishment(String name, String description, String email, String phone, String address, List<Professional> professionals){
        this.name = name;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.createdAt = LocalDateTime.now();
        this.professionals = professionals;
    }
}

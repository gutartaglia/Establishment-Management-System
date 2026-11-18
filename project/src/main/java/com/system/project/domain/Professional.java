package com.system.project.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@EqualsAndHashCode  
@Document(collection = "professionals") 
public class Professional {
    

    @Id 
    private String id;

    @NotBlank 
    private String name;

    @Email 
    @NotBlank 
    private String email;

    @NotBlank 
    private String phone;

    private boolean active = true;

    @NotNull
    @DBRef(lazy = true)
    private Establishment establishment;

    public Professional(String name, String email, String phone, Establishment establishment){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.establishment = establishment;
    }

}

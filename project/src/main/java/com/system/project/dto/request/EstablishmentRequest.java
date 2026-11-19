package com.system.project.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor  
public class EstablishmentRequest {
    
    @NotBlank 
    private String name;

    private String description;

    @NotBlank 
    @Email 
    private String email;

    @NotBlank 
    private String phone;

    @NotBlank 
    private String address;


}

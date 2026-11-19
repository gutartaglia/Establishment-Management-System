package com.system.project.dto.request;

import com.system.project.domain.Establishment;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor  
public class ProfessionalRequest {
    
    @NotBlank 
    private String name;

    @NotBlank 
    @Email 
    private String email;

    @NotBlank 
    private String phone;

    @NotNull
    private Establishment establishment;

}

package com.system.project.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.project.dto.request.ProfessionalRequest;
import com.system.project.dto.response.ProfessionalResponse;
import com.system.project.services.ProfessionalService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@RestController 
public class ProfessionalController {
    
    private final ProfessionalService service;

    @PostMapping(path = "/professionals")
    public ResponseEntity<ProfessionalResponse> create(@Valid @RequestBody ProfessionalRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    } 

    @GetMapping(path = "/professionals")
    public ResponseEntity<List<ProfessionalResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    } 


}

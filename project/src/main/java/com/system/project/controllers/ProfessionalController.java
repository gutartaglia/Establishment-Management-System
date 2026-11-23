package com.system.project.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.project.dto.request.ProfessionalRequest;
import com.system.project.dto.response.ProfessionalResponse;
import com.system.project.services.ProfessionalService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@RestController
@RequestMapping(path = "/professionals")
public class ProfessionalController {
    
    private final ProfessionalService service;

    @PostMapping
    public ResponseEntity<ProfessionalResponse> create(@Valid @RequestBody ProfessionalRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    } 

    @GetMapping
    public ResponseEntity<List<ProfessionalResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    } 

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProfessionalResponse> findById(@PathVariable String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(path = "establishments/{establishmentId}")
    public ResponseEntity<List<ProfessionalResponse>> findAllByEstablishment(@PathVariable String establishmentId){
        return ResponseEntity.ok(service.findAllByEstablishment(establishmentId));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProfessionalResponse> update(@PathVariable String id, @Valid @RequestBody ProfessionalRequest request){
        ProfessionalResponse pResponse = service.update(id, request);
        return ResponseEntity.ok(pResponse);
    }  

    @PatchMapping(path = "/{id}/deactive")
    public ResponseEntity<Void> deactiveProfessional(@PathVariable String id){
        service.deactiveProfessional(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(path = "/{id}/active")
    public ResponseEntity<Void> activeProfessional(@PathVariable String id){
        service.activeProfessional(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}

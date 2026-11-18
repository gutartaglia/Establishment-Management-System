package com.system.project.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.project.dto.request.EstablishmentRequest;
import com.system.project.dto.response.EstablishmentResponse;
import com.system.project.services.EstablishmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@RestController
@RequestMapping(path = "/establishments")
public class EstablishmentController {


    private final EstablishmentService service;

    @PostMapping 
    public ResponseEntity<EstablishmentResponse> insert(@Valid @RequestBody EstablishmentRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(request));
    }

    @GetMapping 
    public ResponseEntity<List<EstablishmentResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}") 
    public ResponseEntity<EstablishmentResponse> findById(@PathVariable String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PatchMapping(path = "/{id}/deactive")
    public ResponseEntity<Void> deactiveEstablishment(@PathVariable String id){
        service.deactiveEstablishment(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EstablishmentResponse> update(@PathVariable String id, @Valid @RequestBody EstablishmentRequest establishmentRequest){
        EstablishmentResponse eResponse = service.update(id, establishmentRequest);
        return ResponseEntity.ok(eResponse);
    }




}

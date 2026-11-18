package com.system.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.project.domain.Establishment;
import com.system.project.dto.request.EstablishmentRequest;
import com.system.project.dto.response.EstablishmentResponse;
import com.system.project.mappers.EstablishmentMapper;
import com.system.project.repositories.EstablishmentRepository;
import com.system.project.services.exceptions.BusinessException;
import com.system.project.services.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class EstablishmentService {
    
    private final EstablishmentRepository repository;

    private final EstablishmentMapper eMapper;

    public EstablishmentResponse insert(EstablishmentRequest request){
        if (repository.existsByEmail(request.getEmail())){
            throw new BusinessException("Email já cadastrado");
        }
        Establishment saved = repository.save(eMapper.toEntity(request));
        return eMapper.toResponse(saved);
    }

    public List<EstablishmentResponse> findAll(){
        return repository.findAll().stream().map(eMapper::toResponse).toList();
    }

    public EstablishmentResponse findById(String id){
        Establishment establishment = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
        return eMapper.toResponse(establishment);
    }

    public EstablishmentResponse deactiveEstablishment(String id){
        Establishment establishment = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
        if (!establishment.isActive()) {
            throw new BusinessException("Estabelecimento já está inativo");
        }
        establishment.setActive(false);
        Establishment saved = repository.save(establishment);
        return eMapper.toResponse(saved);
    }

    public EstablishmentResponse update(String id, EstablishmentRequest request){
        Establishment establishment = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
        eMapper.updateEstablishment(establishment, request);
        if (repository.existsByEmailAndIdNot(request.getEmail(), id)){
            throw new BusinessException("Email já cadastrado");
        }
        Establishment saved = repository.save(establishment);
        return eMapper.toResponse(saved);
    }

    public void delete(String id){
        Establishment establishment = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
        repository.delete(establishment);
    }

}

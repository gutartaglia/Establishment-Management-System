package com.system.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.project.domain.Professional;
import com.system.project.dto.request.ProfessionalRequest;
import com.system.project.dto.response.ProfessionalResponse;
import com.system.project.mappers.ProfessionalMapper;
import com.system.project.repositories.ProfessionalRepository;
import com.system.project.services.exceptions.BusinessException;
import com.system.project.services.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class ProfessionalService {
    
    private final ProfessionalRepository repository;

    private final ProfessionalMapper pMapper;

    public ProfessionalResponse create(ProfessionalRequest request){
        if (repository.existsByEmail(request.getEmail())){
            throw new BusinessException("Email já cadastrado");
        }
        Professional saved = repository.save(pMapper.toEntity(request));
        return pMapper.toResponse(saved);
    }

    public List<ProfessionalResponse> findAll(){
        return repository.findAll().stream().map(pMapper::toResponse).toList();
    }

    public ProfessionalResponse findById(String id){
        Professional professional = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado"));
        return pMapper.toResponse(professional);
    }

    public List<ProfessionalResponse> findAllByEstablishment(String establishmentId){
        return repository.findByEstablishmentId(establishmentId).stream().map(pMapper::toResponse).toList();
    }

    public ProfessionalResponse update(String id, ProfessionalRequest request){
        Professional professional = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado"));
        pMapper.updateProfessional(request, professional);
        if (repository.existsByEmailAndIdNot(professional.getEmail(), id)){
            throw new BusinessException("Email já cadastrado");
        }
        Professional saved = repository.save(professional);
        return pMapper.toResponse(saved);
    }

    public ProfessionalResponse deactiveProfessional(String id){
        Professional professional = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado"));
        if (!professional.isActive()){
            throw new BusinessException("Profissional já está inativo");
        }
        professional.setActive(false);
        Professional saved = repository.save(professional);
        return pMapper.toResponse(saved);
    }    

    public void delete(String id){
        Professional professional = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado"));
        repository.delete(professional);
    }

}

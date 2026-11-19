package com.example.pacoteturismospring.service;

import com.example.pacoteturismospring.DTO.PacoteOutputDTO;
import com.example.pacoteturismospring.DTO.PacoteInputDTO;
import com.example.pacoteturismospring.model.Pacote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;

    public PacoteOutputDTO create(PacoteInputDTO inputDTO){
        Pacote pacote = inputDTO.build();
        Pacote estado = pacoteRepository.save(pacote);
        return new PacoteOutputDTO(salvo);
    }
}

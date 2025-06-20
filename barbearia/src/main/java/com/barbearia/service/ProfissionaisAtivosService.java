package com.barbearia.service;

import com.barbearia.model.ProfissionaisAtivos;
import com.barbearia.repository.ProfissionaisAtivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionaisAtivosService {

    @Autowired
    private ProfissionaisAtivosRepository repository;

    public List<ProfissionaisAtivos> listarProfissionaisAtivos() {
        return repository.findAll();
    }
}

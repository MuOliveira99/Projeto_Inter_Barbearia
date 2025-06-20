package com.barbearia.service;

import com.barbearia.model.AgendamentosPorProfissional;
import com.barbearia.repository.AgendamentosPorProfissionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentosPorProfissionalService {

    private final AgendamentosPorProfissionalRepository repository;

    public AgendamentosPorProfissionalService(AgendamentosPorProfissionalRepository repository) {
        this.repository = repository;
    }

    public List<AgendamentosPorProfissional> listarTodos() {
        return repository.findAll();
    }
}

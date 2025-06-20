package com.barbearia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barbearia.model.Profissional;
import com.barbearia.repository.ProfissionalRepository;

@Service
public class ProfissionalService {
    private final ProfissionalRepository repo;

    public ProfissionalService(ProfissionalRepository repo) {
        this.repo = repo;
    }

    // Listar todos os profissionais
    public List<Profissional> listar() {
        return repo.findAll();
    }

    // Salvar um profissional
    public Profissional salvar(Profissional profissional) {
        return repo.save(profissional);
    }

    // Listar apenas profissionais ativos
    public List<Profissional> listarAtivos() {
        return repo.findByAtivoTrue();
    }

    // Excluir um profissional pelo ID
    public void excluirPorId(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new IllegalArgumentException("Profissional com ID " + id + " não encontrado.");
        }
    }

    // Alterar o status de um profissional
    public Profissional alterarStatus(Integer id, Boolean ativo) {
        Profissional profissional = repo.findById(id).orElseThrow(() ->
            new IllegalArgumentException("Profissional com ID " + id + " não encontrado.")
        );
        profissional.setAtivo(ativo);
        return repo.save(profissional);
    }


}


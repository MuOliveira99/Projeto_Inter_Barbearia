package com.barbearia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.model.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {
    
    // Lista todos os profissionais ativos
    List<Profissional> findByAtivoTrue();

    // Busca profissionais por nome contendo a string especificada (case insensitive)
    List<Profissional> findByNomeContainingIgnoreCase(String nome);

    // Conta o número de profissionais ativos
    long countByAtivoTrue();

    // Exclui todos os profissionais inativos
    void deleteByAtivoFalse();
}

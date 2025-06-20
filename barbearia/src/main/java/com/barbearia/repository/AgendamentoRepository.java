package com.barbearia.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    List<Agendamento> findByProfissionalIdAndData(Integer profissionalId, LocalDate data);


  
}



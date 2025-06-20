package com.barbearia.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.barbearia.model.Agendamento;
import com.barbearia.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

   public List<String> horariosDisponiveis(Integer profissionalId, LocalDate data) {
    List<String> todosHorarios = List.of(
        "08:00", "09:00", "10:00", "11:00", "12:00",
        "14:00", "15:00", "16:00", "17:00"
    );

    List<String> ocupados = agendamentoRepository.findByProfissionalIdAndData(profissionalId, data)
        .stream()
        .map(Agendamento::getHorario)
        .collect(Collectors.toList());

    return todosHorarios.stream()
        .filter(h -> !ocupados.contains(h))
        .collect(Collectors.toList());
}





}



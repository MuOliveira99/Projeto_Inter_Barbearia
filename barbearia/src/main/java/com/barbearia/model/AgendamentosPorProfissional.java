package com.barbearia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vw_agendamentos_por_profissional")  // <-- aqui o nome da view no banco
public class AgendamentosPorProfissional {
    @Id
    private String nomeProfissional; // Nome do profissional (usado como identificador)
    private Long totalAgendamentos; // Total de agendamentos

    // Getters e Setters
    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public Long getTotalAgendamentos() {
        return totalAgendamentos;
    }

    public void setTotalAgendamentos(Long totalAgendamentos) {
        this.totalAgendamentos = totalAgendamentos;
    }
}

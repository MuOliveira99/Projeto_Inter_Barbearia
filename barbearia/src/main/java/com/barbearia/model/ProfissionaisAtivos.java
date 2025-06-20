package com.barbearia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProfissionaisAtivos {

    @Id
    private Integer profissionalId;
    private String nomeProfissional;
    private String especialidade;

    // Getters e Setters
    public Integer getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Integer profissionalId) {
        this.profissionalId = profissionalId;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}

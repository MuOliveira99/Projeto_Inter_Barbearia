
package com.barbearia.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String cpf;

    private String nome;
    private String telefone;
    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoAcesso tipoAcesso = TipoAcesso.cliente;

    public enum TipoAcesso {
        cliente, admin
    }

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public TipoAcesso getTipoAcesso() { return tipoAcesso; }
    public void setTipoAcesso(TipoAcesso tipoAcesso) { this.tipoAcesso = tipoAcesso; }
}

package com.bambu.backend.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "arquiteto")
public class ArquitetoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private String cpf;

    private String cadastro_cau;

    private String email;

    private String senha;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCadastro_cau() {
        return cadastro_cau;
    }

    public void setCadastro_cau(String cadastro_cau) {
        this.cadastro_cau = cadastro_cau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

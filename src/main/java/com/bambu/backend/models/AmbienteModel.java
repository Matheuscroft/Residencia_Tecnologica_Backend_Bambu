package com.bambu.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "ambiente")
@Data
public class AmbienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private float tamanho;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "projeto_id", nullable = false)
    private ProjetoModel projeto;

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

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public ProjetoModel getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoModel projeto) {
        this.projeto = projeto;
    }
}

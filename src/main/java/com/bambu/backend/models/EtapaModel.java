package com.bambu.backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "etapa")
@Data
public class EtapaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nomeDaEtapa;

    private String descricao;

    private Date dataDeInicio;

    private Date dataPrevistaFim;

    private float valorEtapa;

    @ManyToOne
    @JoinColumn(name = "projeto_id", nullable = false)
    private ProjetoModel projeto;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeDaEtapa() {
        return nomeDaEtapa;
    }

    public void setNomeDaEtapa(String nomeDaEtapa) {
        this.nomeDaEtapa = nomeDaEtapa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(Date dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public Date getDataPrevistaFim() {
        return dataPrevistaFim;
    }

    public void setDataPrevistaFim(Date dataPrevistaFim) {
        this.dataPrevistaFim = dataPrevistaFim;
    }

    public float getValorEtapa() {
        return valorEtapa;
    }

    public void setValorEtapa(float valorEtapa) {
        this.valorEtapa = valorEtapa;
    }

    public ProjetoModel getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoModel projeto) {
        this.projeto = projeto;
    }
}

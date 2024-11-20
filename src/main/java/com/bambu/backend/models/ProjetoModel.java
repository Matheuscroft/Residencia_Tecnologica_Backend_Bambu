package com.bambu.backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
import java.util.Date;

@Entity
@Table(name = "projeto")
@Data
public class ProjetoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nomeDoProjeto;

    private String endereco;

    private String descricao;

    private Date dataDeInicio;

    private Date dataPrevistaFim;

    private String tipoObra;

    private float valorProjeto;

    private float porcentagemEtapa1;

    private float porcentagemEtapa2;

    private float porcentagemEtapa3;

    private float porcentagemEtapa4;

    private float porcentagemEtapa5;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeDoProjeto() {
        return nomeDoProjeto;
    }

    public void setNomeDoProjeto(String nomeDoProjeto) {
        this.nomeDoProjeto = nomeDoProjeto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getTipoObra() {
        return tipoObra;
    }

    public void setTipoObra(String tipoObra) {
        this.tipoObra = tipoObra;
    }

    public float getValorProjeto() {
        return valorProjeto;
    }

    public void setValorProjeto(float valorProjeto) {
        this.valorProjeto = valorProjeto;
    }

    public float getPorcentagemEtapa1() {
        return porcentagemEtapa1;
    }

    public void setPorcentagemEtapa1(float porcentagemEtapa1) {
        this.porcentagemEtapa1 = porcentagemEtapa1;
    }

    public float getPorcentagemEtapa2() {
        return porcentagemEtapa2;
    }

    public void setPorcentagemEtapa2(float porcentagemEtapa2) {
        this.porcentagemEtapa2 = porcentagemEtapa2;
    }

    public float getPorcentagemEtapa3() {
        return porcentagemEtapa3;
    }

    public void setPorcentagemEtapa3(float porcentagemEtapa3) {
        this.porcentagemEtapa3 = porcentagemEtapa3;
    }

    public float getPorcentagemEtapa4() {
        return porcentagemEtapa4;
    }

    public void setPorcentagemEtapa4(float porcentagemEtapa4) {
        this.porcentagemEtapa4 = porcentagemEtapa4;
    }

    public float getPorcentagemEtapa5() {
        return porcentagemEtapa5;
    }

    public void setPorcentagemEtapa5(float porcentagemEtapa5) {
        this.porcentagemEtapa5 = porcentagemEtapa5;
    }
}

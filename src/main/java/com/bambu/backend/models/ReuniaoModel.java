package com.bambu.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "reuniao")
public class ReuniaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nomeReuniao;

    private Date dataReuniao;

    private String local;

    private String apontamentos;

    @ManyToOne
    @JoinColumn(name = "etapa_id")
    @JsonBackReference
    private EtapaModel etapa;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeReuniao() {
        return nomeReuniao;
    }

    public void setNomeReuniao(String nomeReuniao) {
        this.nomeReuniao = nomeReuniao;
    }

    public Date getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(Date dataReuniao) {
        this.dataReuniao = dataReuniao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getApontamentos() {
        return apontamentos;
    }

    public void setApontamentos(String apontamentos) {
        this.apontamentos = apontamentos;
    }

    public EtapaModel getEtapa() {
        return etapa;
    }

    public void setEtapa(EtapaModel etapa) {
        this.etapa = etapa;
    }
}

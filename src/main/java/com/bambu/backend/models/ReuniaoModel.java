package com.bambu.backend.models;

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
}

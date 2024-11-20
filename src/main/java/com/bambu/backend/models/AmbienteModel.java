package com.bambu.backend.models;

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

    private String nomeAmbiente;

    private String tipoAmbiente;

    private String tamanhoAmbiente;
}

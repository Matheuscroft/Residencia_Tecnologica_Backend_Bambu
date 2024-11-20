package com.bambu.backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AmbienteDto(@NotNull String nomeAmbiente,
                          @NotBlank String tipoAmbiente,
                          @NotNull String tamanhoAmbiente) {
}

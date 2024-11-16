package com.bambu.backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ProjetoDto (@NotBlank String nomeDoProjeto, @NotNull float valorProjeto, @NotNull Date dataDeInicio ){
}

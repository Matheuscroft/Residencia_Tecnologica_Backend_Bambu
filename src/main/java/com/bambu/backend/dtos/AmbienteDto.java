package com.bambu.backend.dtos;

import java.util.List;
//public record AmbienteDto(@NotNull String nomeAmbiente,
//                          @NotBlank String tipoAmbiente,
//                          @NotNull String tamanhoAmbiente) {
public class AmbienteDto {

    private String nome;
    private String tamanho;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

}

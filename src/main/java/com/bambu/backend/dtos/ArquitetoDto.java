package com.bambu.backend.dtos;

public class ArquitetoDto {

    private String nome;

    private String cpf;

    private String numero_cau;

    private String email;

    private String senha;


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

    public String getNumero_cau() {
        return numero_cau;
    }

    public void setNumero_cau(String numero_cau) {
        this.numero_cau = numero_cau;
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

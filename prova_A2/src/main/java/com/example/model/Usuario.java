package com.example.model;

public class Usuario {
    private String email; // chave primária
    private String senha;
    private String nome;
    private TipoUsuario tipoUsuario;

    public enum TipoUsuario {
        ADMIN,
        EDITOR,
        LEITOR
    }

    // Construtores
    public Usuario() {}

    public Usuario(String email, String senha, String nome, TipoUsuario tipoUsuario) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters e Setters
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }
}
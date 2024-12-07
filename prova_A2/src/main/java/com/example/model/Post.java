package com.example.model;

import java.time.LocalDateTime;

public class Post {
    private Long id;
    private String titulo;
    private String conteudo;
    private LocalDateTime dataPublicacao;
    private String emailUsuario; // chave estrangeira

    // Construtores
    public Post() {
        this.dataPublicacao = LocalDateTime.now();
    }

    public Post(String titulo, String conteudo, String emailUsuario) {
        this();
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.emailUsuario = emailUsuario;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", emailUsuario='" + emailUsuario + '\'' +
                '}';
    }
}
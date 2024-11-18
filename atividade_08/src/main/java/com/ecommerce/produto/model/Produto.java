package com.ecommerce.produto.model;

public class Produto {
    private Integer id;
    private String tipo;
    private String descricao;
    private double peso;
    private int quantidade;
    private UnidadeMedida unidadeMedida;

    // Construtor sem ID
    public Produto(String tipo, String descricao, double peso, int quantidade, UnidadeMedida unidadeMedida) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.peso = peso;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
    }

    // Construtor com ID
    public Produto(Integer id, String tipo, String descricao, double peso, int quantidade, UnidadeMedida unidadeMedida) {
        this(tipo, descricao, peso, quantidade, unidadeMedida);
        this.id = id;
    }

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public UnidadeMedida getUnidadeMedida() { return unidadeMedida; }
    public void setUnidadeMedida(UnidadeMedida unidadeMedida) { this.unidadeMedida = unidadeMedida; }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", peso=" + peso +
                ", quantidade=" + quantidade +
                ", unidadeMedida=" + unidadeMedida +
                '}';
    }
}
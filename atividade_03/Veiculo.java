package atividade_03;

public abstract class Veiculo {
    protected String tipo;
    protected double peso;

    public Veiculo(String tipo, double peso) {
        this.tipo = tipo;
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPeso() {
        return peso;
    }

    public abstract boolean podeEstacionar();

    public abstract double calcularPrecoPorHora();
}
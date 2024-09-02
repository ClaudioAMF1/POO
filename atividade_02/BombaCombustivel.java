package atividade_02;

public class BombaCombustivel {
    private String tipoCombustivel;
    private double valorLitro;
    private double quantidadeCombustivel;
    private double valorTotalAbastecido;

    public BombaCombustivel(String tipoCombustivel, double valorLitro, double quantidadeCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
        this.valorLitro = valorLitro;
        this.quantidadeCombustivel = quantidadeCombustivel;
        this.valorTotalAbastecido = 0;
    }

    public void abastecerPorValor(double valor) {
        double litros = valor / valorLitro;
        if (litros <= quantidadeCombustivel) {
            quantidadeCombustivel -= litros;
            valorTotalAbastecido += valor;
            System.out.printf("Abastecido: %.2f litros de %s\n", litros, tipoCombustivel);
        } else {
            System.out.println("Quantidade insuficiente de combustível na bomba.");
        }
    }

    public void abastecerPorLitro(double litros) {
        double valor = litros * valorLitro;
        if (litros <= quantidadeCombustivel) {
            quantidadeCombustivel -= litros;
            valorTotalAbastecido += valor;
            System.out.printf("Valor a pagar: R$ %.2f\n", valor);
        } else {
            System.out.println("Quantidade insuficiente de combustível na bomba.");
        }
    }

    public void alterarValor(double novoValor) {
        this.valorLitro = novoValor;
    }

    public void alterarCombustivel(String novoTipo) {
        this.tipoCombustivel = novoTipo;
    }

    public void alterarQuantidadeCombustivel(double novaQuantidade) {
        this.quantidadeCombustivel = novaQuantidade;
    }

    public double getValorTotalAbastecido() {
        return valorTotalAbastecido;
    }

    public double getQuantidadeCombustivel() {
        return quantidadeCombustivel;
    }
}

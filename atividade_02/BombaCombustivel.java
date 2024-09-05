package atividade_02;

import java.util.HashMap;
import java.util.Map;

public class BombaCombustivel {
    private Map<TipoCombustivel, Double> valorLitro;
    private Map<TipoCombustivel, Double> quantidadeCombustivel;
    private Map<TipoCombustivel, Double> valorTotalAbastecido;

    public BombaCombustivel() {
        // Inicializa os mapas para cada tipo de combustível
        valorLitro = new HashMap<>();
        quantidadeCombustivel = new HashMap<>();
        valorTotalAbastecido = new HashMap<>();

        // Definindo valores padrão para os combustíveis
        valorLitro.put(TipoCombustivel.GASOLINA, 5.99);
        valorLitro.put(TipoCombustivel.DIESEL, 4.59);
        valorLitro.put(TipoCombustivel.ETANOL, 3.79);

        quantidadeCombustivel.put(TipoCombustivel.GASOLINA, 1000.0);
        quantidadeCombustivel.put(TipoCombustivel.DIESEL, 800.0);
        quantidadeCombustivel.put(TipoCombustivel.ETANOL, 1200.0);

        valorTotalAbastecido.put(TipoCombustivel.GASOLINA, 0.0);
        valorTotalAbastecido.put(TipoCombustivel.DIESEL, 0.0);
        valorTotalAbastecido.put(TipoCombustivel.ETANOL, 0.0);
    }

    public void abastecerPorValor(TipoCombustivel tipo, double valor) {
        double litros = valor / valorLitro.get(tipo);
        if (litros <= quantidadeCombustivel.get(tipo)) {
            quantidadeCombustivel.put(tipo, quantidadeCombustivel.get(tipo) - litros);
            valorTotalAbastecido.put(tipo, valorTotalAbastecido.get(tipo) + valor);
            System.out.printf("Abastecido: %.2f litros de %s\n", litros, tipo);
        } else {
            System.out.println("Quantidade insuficiente de " + tipo + " na bomba.");
        }
    }

    public void abastecerPorLitro(TipoCombustivel tipo, double litros) {
        double valor = litros * valorLitro.get(tipo);
        if (litros <= quantidadeCombustivel.get(tipo)) {
            quantidadeCombustivel.put(tipo, quantidadeCombustivel.get(tipo) - litros);
            valorTotalAbastecido.put(tipo, valorTotalAbastecido.get(tipo) + valor);
            System.out.printf("Valor a pagar: R$ %.2f por %.2f litros de %s\n", valor, litros, tipo);
        } else {
            System.out.println("Quantidade insuficiente de " + tipo + " na bomba.");
        }
    }

    public void alterarValor(TipoCombustivel tipo, double novoValor) {
        valorLitro.put(tipo, novoValor);
    }

    public void alterarQuantidadeCombustivel(TipoCombustivel tipo, double novaQuantidade) {
        quantidadeCombustivel.put(tipo, novaQuantidade);
    }

    public double getValorTotalAbastecido(TipoCombustivel tipo) {
        return valorTotalAbastecido.get(tipo);
    }

    public double getQuantidadeCombustivel(TipoCombustivel tipo) {
        return quantidadeCombustivel.get(tipo);
    }
}

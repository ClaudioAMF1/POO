package atividade_03;

public class Caminhonete extends Veiculo {
    private boolean carregada;

    public Caminhonete(double peso, boolean carregada) {
        super("Caminhonete", peso);
        this.carregada = carregada;
    }

    @Override
    public boolean podeEstacionar() {
        return peso <= 6;
    }

    @Override
    public double calcularPrecoPorHora() {
        if (carregada && peso > 3) {
            return 50.0;
        } else {
            return 25.0;
        }
    }
}
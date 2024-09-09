package atividade_03;

public class Furgao extends Veiculo {
    private double volume;

    public Furgao(double peso, double volume) {
        super("Furgão", peso);
        this.volume = volume;
    }

    @Override
    public boolean podeEstacionar() {
        return peso <= 6 && volume <= 18;
    }

    @Override
    public double calcularPrecoPorHora() {
        if (peso > 3) {
            return 50.0;
        } else {
            return 25.0;
    }
}
package atividade_03;

public class Motocicleta extends Veiculo {

    public Motocicleta(double peso) {
        super("Motocicleta", peso);
    }

    @Override
    public boolean podeEstacionar() {
        return peso <= 400;
    }

    @Override
    public double calcularPrecoPorHora() {
        if (peso <= 100) {
            return 2.0;
        } else if (peso <= 299.9) {
            return 4.0;
        } else {
            return 10.0;
        }
    }
}
package atividade_03;

public class CarroDePasseio extends Veiculo {
    private String categoria;

    public CarroDePasseio(String categoria, double peso) {
        super("Carro de Passeio", peso);
        this.categoria = categoria;
    }

    @Override
    public boolean podeEstacionar() {
        return peso <= 2; 
    }

    @Override
    public double calcularPrecoPorHora() {
        if (peso > 2) {
            Furgao furgao = new Furgao(peso, 0); 
            return furgao.calcularPrecoPorHora();
        }

        switch (categoria.toLowerCase()) {
            case "hatchback":
                return 13.0;
            case "sedan":
                return 15.0;
            case "suv":
                return 20.0;
            default:
                throw new IllegalArgumentException("Categoria de carro de passeio inválida");
        }
    }
}
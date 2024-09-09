package atividade_03;

import java.util.Scanner;

public class GaragemEstacionamento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("      BEM-VINDO À GARAGEM!");
        System.out.println("=====================================");

        while (true) {
            System.out.println("Deseja informar um novo veículo? (sim/nao)");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("nao")) {
                System.out.println("Saindo do sistema...");
                break;
            }

            System.out.println("Informe o tipo de veículo (motocicleta, carro de passeio, caminhonete, furgao): ");
            String tipo = scanner.nextLine().toLowerCase();

            Veiculo veiculo = null;

            switch (tipo) {
                case "motocicleta":
                    System.out.println("Informe o peso da motocicleta (kg): ");
                    double pesoMoto = scanner.nextDouble();
                    scanner.nextLine();
                    veiculo = new Motocicleta(pesoMoto);
                    break;
                case "carro de passeio":
                    System.out.println("Informe a categoria do carro de passeio (hatchback, sedan, SUV): ");
                    String categoria = scanner.nextLine().toLowerCase();
                    System.out.println("Informe o peso do carro (ton): ");
                    double pesoCarro = scanner.nextDouble();
                    scanner.nextLine();
                    veiculo = new CarroDePasseio(categoria, pesoCarro);
                    break;
                case "caminhonete":
                    System.out.println("Informe o peso da caminhonete (ton): ");
                    double pesoCaminhonete = scanner.nextDouble();
                    System.out.println("A caminhonete está carregada? (sim/nao): ");
                    boolean carregada = scanner.next().equalsIgnoreCase("sim");
                    scanner.nextLine();
                    veiculo = new Caminhonete(pesoCaminhonete, carregada);
                    break;
                case "furgao":
                    System.out.println("Informe o peso do furgão (ton): ");
                    double pesoFurgao = scanner.nextDouble();
                    System.out.println("Informe o volume do furgão (m³): ");
                    double volumeFurgao = scanner.nextDouble();
                    scanner.nextLine();
                    veiculo = new Furgao(pesoFurgao, volumeFurgao);
                    break;
                default:
                    System.out.println("Tipo de veículo inválido.");
                    continue;
            }

            if (veiculo != null) {
                if (!veiculo.podeEstacionar()) {
                    System.out.println("Este veículo não pode ser aceito no estacionamento.");
                } else {
                    System.out.println("O valor por hora para estacionar este " + veiculo.getTipo() + " é R$ " + veiculo.calcularPrecoPorHora());
                }
            }

            System.out.println("=====================================");
        }

        scanner.close();
    }
}

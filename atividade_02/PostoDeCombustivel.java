package atividade_02;

import java.util.Scanner;

public class PostoDeCombustivel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando uma bomba de combustível
        BombaCombustivel bomba = new BombaCombustivel("Gasolina", 5.99, 1000);

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Abastecer por valor");
            System.out.println("2. Abastecer por litros");
            System.out.println("3. Alterar valor do litro");
            System.out.println("4. Alterar tipo de combustível");
            System.out.println("5. Alterar quantidade de combustível na bomba");
            System.out.println("6. Ver valor total abastecido");
            System.out.println("7. Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para abastecimento: R$ ");
                    double valor = scanner.nextDouble();
                    bomba.abastecerPorValor(valor);
                    break;
                case 2:
                    System.out.print("Digite a quantidade de litros para abastecimento: ");
                    double litros = scanner.nextDouble();
                    bomba.abastecerPorLitro(litros);
                    break;
                case 3:
                    System.out.print("Digite o novo valor do litro: R$ ");
                    double novoValor = scanner.nextDouble();
                    bomba.alterarValor(novoValor);
                    break;
                case 4:
                    System.out.print("Digite o novo tipo de combustível: ");
                    String novoTipo = scanner.next();
                    bomba.alterarCombustivel(novoTipo);
                    break;
                case 5:
                    System.out.print("Digite a nova quantidade de combustível na bomba: ");
                    double novaQuantidade = scanner.nextDouble();
                    bomba.alterarQuantidadeCombustivel(novaQuantidade);
                    break;
                case 6:
                    System.out.printf("Valor total abastecido na bomba: R$ %.2f\n", bomba.getValorTotalAbastecido());
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);

        scanner.close();
    }
}
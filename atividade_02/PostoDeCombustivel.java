package atividade_02;

import java.util.Scanner;

public class PostoDeCombustivel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BombaCombustivel bomba = new BombaCombustivel();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Abastecer por valor");
            System.out.println("2. Abastecer por litros");
            System.out.println("3. Alterar valor do litro");
            System.out.println("4. Alterar quantidade de combustível na bomba");
            System.out.println("5. Ver valor total abastecido");
            System.out.println("6. Sair");
            int opcao = scanner.nextInt();

            if (opcao == 6) {
                continuar = false;
                System.out.println("Encerrando o programa...");
                break;
            }

            TipoCombustivel tipo = escolherTipoCombustivel(scanner);

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para abastecimento: R$ ");
                    double valor = scanner.nextDouble();
                    bomba.abastecerPorValor(tipo, valor);
                    break;
                case 2:
                    System.out.print("Digite a quantidade de litros para abastecimento: ");
                    double litros = scanner.nextDouble();
                    bomba.abastecerPorLitro(tipo, litros);
                    break;
                case 3:
                    System.out.print("Digite o novo valor do litro para " + tipo + ": R$ ");
                    double novoValor = scanner.nextDouble();
                    bomba.alterarValor(tipo, novoValor);
                    break;
                case 4:
                    System.out.print("Digite a nova quantidade de " + tipo + " na bomba: ");
                    double novaQuantidade = scanner.nextDouble();
                    bomba.alterarQuantidadeCombustivel(tipo, novaQuantidade);
                    break;
                case 5:
                    System.out.printf("Valor total abastecido de %s: R$ %.2f\n", tipo, bomba.getValorTotalAbastecido(tipo));
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static TipoCombustivel escolherTipoCombustivel(Scanner scanner) {
        System.out.println("\nEscolha o tipo de combustível:");
        System.out.println("1. Gasolina");
        System.out.println("2. Diesel");
        System.out.println("3. Etanol");
        int tipoCombustivelOpcao = scanner.nextInt();

        switch (tipoCombustivelOpcao) {
            case 1:
                return TipoCombustivel.GASOLINA;
            case 2:
                return TipoCombustivel.DIESEL;
            case 3:
                return TipoCombustivel.ETANOL;
            default:
                System.out.println("Opção inválida. Escolhendo gasolina por padrão.");
                return TipoCombustivel.GASOLINA;
        }
    }
}

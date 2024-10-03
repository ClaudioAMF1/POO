import java.util.InputMismatchException;
import java.util.Scanner;

public class TestaCadastro {
    public static void main(String[] args) {
        CadastroPessoas cadastro = new CadastroPessoas(5);
        Scanner scanner = new Scanner(System.in);
        
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Funcionario");
            System.out.println("3 - Cadastrar Gerente");
            System.out.println("4 - Imprimir Cadastro");
            System.out.println("5 - Acessar pessoa por índice");
            System.out.println("6 - Remover pessoa por índice");
            System.out.println("7 - Sair");

            int opcao = -1;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastro.cadastraPessoa(cadastrarCliente(scanner));
                    break;
                case 2:
                    cadastro.cadastraPessoa(cadastrarFuncionario(scanner));
                    break;
                case 3:
                    cadastro.cadastraPessoa(cadastrarGerente(scanner));
                    break;
                case 4:
                    cadastro.imprimeCadastro();
                    break;
                case 5:
                    System.out.print("Digite o índice da pessoa que deseja acessar: ");
                    int indiceAcesso = lerIndice(scanner);
                    cadastro.acessaPessoaPorIndice(indiceAcesso);
                    break;
                case 6:
                    System.out.print("Digite o índice da pessoa que deseja remover: ");
                    int indiceRemocao = lerIndice(scanner);
                    cadastro.removePessoaPorIndice(indiceRemocao);
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    public static Cliente cadastrarCliente(Scanner scanner) {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        Data dataNascimento = cadastrarData(scanner);
        System.out.print("Código do Cliente: ");
        int codigo = lerInteiro(scanner);
        return new Cliente(nome, dataNascimento, codigo);
    }

    public static Funcionario cadastrarFuncionario(Scanner scanner) {
        System.out.print("Nome do Funcionário: ");
        String nome = scanner.nextLine();
        Data dataNascimento = cadastrarData(scanner);
        System.out.print("Salário do Funcionário: ");
        float salario = lerFloat(scanner);
        return new Funcionario(nome, dataNascimento, salario);
    }

    public static Gerente cadastrarGerente(Scanner scanner) {
        System.out.print("Nome do Gerente: ");
        String nome = scanner.nextLine();
        Data dataNascimento = cadastrarData(scanner);
        System.out.print("Salário do Gerente: ");
        float salario = lerFloat(scanner);
        System.out.print("Área do Gerente: ");
        String area = scanner.nextLine();
        return new Gerente(nome, dataNascimento, salario, area);
    }

    public static Data cadastrarData(Scanner scanner) {
        int dia = -1, mes = -1, ano = -1;
        System.out.print("Dia de nascimento: ");
        dia = lerInteiro(scanner);
        System.out.print("Mês de nascimento: ");
        mes = lerInteiro(scanner);
        System.out.print("Ano de nascimento: ");
        ano = lerInteiro(scanner);
        return new Data(dia, mes, ano);
    }

    public static int lerInteiro(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine();
            }
        }
    }

    public static float lerFloat(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número decimal.");
                scanner.nextLine();
            }
        }
    }

    public static int lerIndice(Scanner scanner) {
        return lerInteiro(scanner);
    }
}

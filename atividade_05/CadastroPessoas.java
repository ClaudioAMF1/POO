import java.util.Scanner;

public class CadastroPessoas {
    private static PessoaService pessoaService = new PessoaService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== MENU DE CADASTRO ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Funcionario");
            System.out.println("3. Cadastrar Gerente");
            System.out.println("4. Listar todas as Pessoas Cadastradas");
            System.out.println("5. Sair");
            System.out.println("========================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarFuncionario();
                    break;
                case 3:
                    cadastrarGerente();
                    break;
                case 4:
                    listarPessoasCadastradas();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

    private static void cadastrarCliente() {
        System.out.println("\n=== Cadastro de Cliente ===");
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        // Validação de CPF
        String cpf;
        do {
            System.out.print("Digite o CPF do cliente (11 dígitos): ");
            cpf = scanner.nextLine();
            if (cpf.length() != 11) {
                System.out.println("CPF inválido, deve conter exatamente 11 dígitos.");
            }
        } while (cpf.length() != 11);

        System.out.print("Digite o código do cliente: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a linha

        System.out.print("O cliente é VIP? (s/n): ");
        String resposta = scanner.nextLine();

        int dia, mes, ano;

        // Validação para o dia
        do {
            System.out.print("Digite o dia de nascimento (1-31): ");
            dia = scanner.nextInt();
            if (dia < 1 || dia > 31) {
                System.out.println("Dia inválido, tente novamente.");
            }
        } while (dia < 1 || dia > 31);

        // Validação para o mês
        do {
            System.out.print("Digite o mês de nascimento (1-12): ");
            mes = scanner.nextInt();
            if (mes < 1 || mes > 12) {
                System.out.println("Mês inválido, tente novamente.");
            }
        } while (mes < 1 || mes > 12);

        // Validação para o ano
        do {
            System.out.print("Digite o ano de nascimento (1900-2100): ");
            ano = scanner.nextInt();
            if (ano < 1900 || ano > 2100) {
                System.out.println("Ano inválido, tente novamente.");
            }
        } while (ano < 1900 || ano > 2100);

        Data dataNascimento = new Data(dia, mes, ano);

        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Digite o percentual de desconto para o cliente VIP: ");
            double percentualDesconto = scanner.nextDouble();
            ClienteVip clienteVip = new ClienteVip(nome, cpf, dataNascimento, codigo, percentualDesconto);
            pessoaService.cadastrarCliente(clienteVip);
            System.out.println("Cliente VIP cadastrado com sucesso!");
        } else {
            Cliente cliente = new Cliente(nome, cpf, dataNascimento, codigo);
            pessoaService.cadastrarCliente(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        }
    }

    private static void cadastrarFuncionario() {
        System.out.println("\n=== Cadastro de Funcionário ===");
        try {
            if (pessoaService.getFuncionarios().size() >= 7) {
                throw new QuantidadeExcedidaException("Limite de funcionários excedido! Não é possível cadastrar mais de 7 funcionários.");
            }

            System.out.print("Digite o nome do funcionário: ");
            String nome = scanner.nextLine();

            // Validação de CPF
            String cpf;
            do {
                System.out.print("Digite o CPF do funcionário (11 dígitos): ");
                cpf = scanner.nextLine();
                if (cpf.length() != 11) {
                    System.out.println("CPF inválido, deve conter exatamente 11 dígitos.");
                }
            } while (cpf.length() != 11);

            System.out.print("Digite o salário do funcionário: ");
            float salario = scanner.nextFloat();

            System.out.print("Digite o dia de nascimento (1-31): ");
            int dia = scanner.nextInt();
            System.out.print("Digite o mês de nascimento (1-12): ");
            int mes = scanner.nextInt();
            System.out.print("Digite o ano de nascimento (1900-2100): ");
            int ano = scanner.nextInt();

            Data dataNascimento = new Data(dia, mes, ano);
            Funcionario funcionario = new Funcionario(nome, cpf, dataNascimento, salario);
            pessoaService.cadastrarFuncionario(funcionario);
            System.out.println("Funcionário cadastrado com sucesso!");

        } catch (QuantidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void cadastrarGerente() {
        System.out.println("\n=== Cadastro de Gerente ===");
        try {
            if (pessoaService.getGerente() != null) {
                throw new QuantidadeExcedidaException("Já existe um gerente cadastrado! Apenas 1 gerente é permitido.");
            }

            System.out.print("Digite o nome do gerente: ");
            String nome = scanner.nextLine();

            // Validação de CPF
            String cpf;
            do {
                System.out.print("Digite o CPF do gerente (11 dígitos): ");
                cpf = scanner.nextLine();
                if (cpf.length() != 11) {
                    System.out.println("CPF inválido, deve conter exatamente 11 dígitos.");
                }
            } while (cpf.length() != 11);

            System.out.print("Digite o salário do gerente: ");
            float salario = scanner.nextFloat();

            scanner.nextLine(); // Consumir a linha
            System.out.print("Digite a área do gerente: ");
            String area = scanner.nextLine();

            System.out.print("Digite o dia de nascimento (1-31): ");
            int dia = scanner.nextInt();
            System.out.print("Digite o mês de nascimento (1-12): ");
            int mes = scanner.nextInt();
            System.out.print("Digite o ano de nascimento (1900-2100): ");
            int ano = scanner.nextInt();

            Data dataNascimento = new Data(dia, mes, ano);
            Gerente gerente = new Gerente(nome, cpf, dataNascimento, salario, area);
            pessoaService.cadastrarGerente(gerente);
            System.out.println("Gerente cadastrado com sucesso!");

        } catch (QuantidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listarPessoasCadastradas() {
        System.out.println("\n=== Listagem de Pessoas Cadastradas ===");

        // Listar Clientes
        System.out.println("\n--- Clientes ---");
        if (pessoaService.getClientes().isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : pessoaService.getClientes()) {
                cliente.imprimeDados();
            }
        }

        // Listar Funcionários com o cálculo do imposto
        System.out.println("\n--- Funcionários ---");
        if (pessoaService.getFuncionarios().isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario funcionario : pessoaService.getFuncionarios()) {
                funcionario.imprimeDados();
                System.out.println("Imposto sobre o salário: " + funcionario.calculaImposto());
            }
        }

        // Listar o Gerente com o cálculo do imposto
        System.out.println("\n--- Gerente ---");
        Gerente gerente = pessoaService.getGerente();
        if (gerente == null) {
            System.out.println("Nenhum gerente cadastrado.");
        } else {
            gerente.imprimeDados();
            System.out.println("Imposto sobre o salário: " + gerente.calculaImposto());
        }
    }
}

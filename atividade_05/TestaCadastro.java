public class TestaCadastro {

    public static void main(String[] args) {
        PessoaService pessoaService = new PessoaService();

        // Testando cadastro de Cliente comum
        System.out.println("=== Cadastro de Cliente Comum ===");
        Data dataCliente1 = new Data(10, 5, 1990);
        Cliente cliente1 = new Cliente("João Silva", "12345678901", dataCliente1, 101);
        pessoaService.cadastrarCliente(cliente1);
        System.out.println("Cliente comum cadastrado: João Silva");

        // Testando cadastro de Cliente VIP
        System.out.println("=== Cadastro de Cliente VIP ===");
        Data dataClienteVip1 = new Data(15, 8, 1985);
        ClienteVip clienteVip1 = new ClienteVip("Maria Souza", "11122233344", dataClienteVip1, 102, 10.0);
        pessoaService.cadastrarClienteVip(clienteVip1);
        System.out.println("Cliente VIP cadastrado: Maria Souza");

        // Testando cadastro de Funcionários (até o limite de 7)
        System.out.println("\n=== Cadastro de Funcionários ===");
        try {
            for (int i = 1; i <= 7; i++) {
                Data dataFuncionario = new Data(i, 1 + i, 1980);
                Funcionario funcionario = new Funcionario("Funcionario " + i, "1111111111" + i, dataFuncionario, 2500.0f + i * 100);
                pessoaService.cadastrarFuncionario(funcionario);
                System.out.println("Funcionário cadastrado: Funcionario " + i);
            }
        } catch (QuantidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        // Tentando cadastrar mais um Funcionário (deve lançar exceção)
        System.out.println("\n=== Tentativa de cadastro de funcionário extra ===");
        try {
            Data dataFuncionarioExtra = new Data(1, 10, 1980);
            Funcionario funcionarioExtra = new Funcionario("Funcionario Extra", "12312312345", dataFuncionarioExtra, 3000.0f);
            pessoaService.cadastrarFuncionario(funcionarioExtra);
        } catch (QuantidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        // Testando cadastro de Gerente
        System.out.println("\n=== Cadastro de Gerente ===");
        Data dataGerente1 = new Data(5, 7, 1975);
        Gerente gerente1 = new Gerente("Fernanda Lima", "55566677788", dataGerente1, 5000.0f, "TI");
        try {
            pessoaService.cadastrarGerente(gerente1);
            System.out.println("Gerente cadastrado: Fernanda Lima");
        } catch (QuantidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        // Tentando cadastrar outro Gerente (deve lançar exceção)
        System.out.println("\n=== Tentativa de cadastro de gerente extra ===");
        try {
            Gerente gerente2 = new Gerente("Pedro Santos", "99988877766", dataGerente1, 6000.0f, "Financeiro");
            pessoaService.cadastrarGerente(gerente2);
        } catch (QuantidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        // Listar todas as pessoas cadastradas
        listarPessoasCadastradas(pessoaService);
    }

    // Função auxiliar para listar todas as pessoas cadastradas
    private static void listarPessoasCadastradas(PessoaService pessoaService) {
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

import java.util.Scanner;

public class TestaCadastro {
    public static void main(String[] args) {
        CadastroPessoas cadastro = new CadastroPessoas(5);
        Scanner scanner = new Scanner(System.in);

        cadastro.cadastraPessoa(new Cliente("Carlos Silva", new Data(15, 6, 1985), 101));
        cadastro.cadastraPessoa(new Funcionario("Ana Souza", new Data(12, 3, 1990), 2500f));
        cadastro.cadastraPessoa(new Gerente("Roberto Costa", new Data(2, 8, 1975), 6000f, "TI"));

        System.out.println("Cadastro de pessoas:");
        cadastro.imprimeCadastro();

        System.out.println("\nDigite o índice da pessoa que deseja acessar: ");
        int indice = scanner.nextInt();
        cadastro.acessaPessoaPorIndice(indice);

        System.out.println("\nDigite o índice da pessoa que deseja remover: ");
        indice = scanner.nextInt();
        cadastro.removePessoaPorIndice(indice);

        System.out.println("\nCadastro após remoção:");
        cadastro.imprimeCadastro();

        scanner.close();
    }
}

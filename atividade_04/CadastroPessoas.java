public class CadastroPessoas {
    private Pessoa[] pessoas;
    private int qtdAtual;

    public CadastroPessoas(int tamanho) {
        pessoas = new Pessoa[tamanho];
        qtdAtual = 0;
    }

    public void cadastraPessoa(Pessoa pess) {
        if (qtdAtual < pessoas.length) {
            pessoas[qtdAtual] = pess;
            qtdAtual++;
        } else {
            System.out.println("Cadastro cheio! Não é possível adicionar mais pessoas.");
        }
    }

    public void imprimeCadastro() {
        if (qtdAtual == 0) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            for (int i = 0; i < qtdAtual; i++) {
                if (pessoas[i] != null) {
                    pessoas[i].imprimeDados();
                }
            }
        }
    }

    public void acessaPessoaPorIndice(int indice) {
        try {
            if (pessoas[indice] != null) {
                pessoas[indice].imprimeDados();
            } else {
                System.out.println("Pessoa não cadastrada nesse índice.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Índice inválido. Tente um número entre 0 e " + (qtdAtual - 1));
        }
    }

    public void removePessoaPorIndice(int indice) {
        try {
            if (indice >= 0 && indice < qtdAtual && pessoas[indice] != null) {
                System.out.println("Removendo: ");
                pessoas[indice].imprimeDados();
                pessoas[indice] = null;
                for (int i = indice; i < qtdAtual - 1; i++) {
                    pessoas[i] = pessoas[i + 1];
                }
                pessoas[qtdAtual - 1] = null;
                qtdAtual--;
                System.out.println("Pessoa removida com sucesso.");
            } else {
                System.out.println("Erro: Pessoa não cadastrada nesse índice.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Índice inválido. Tente um número entre 0 e " + (qtdAtual - 1));
        }
    }
}

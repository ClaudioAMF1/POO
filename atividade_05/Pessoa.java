public class Pessoa {
    private String nome;
    private String cpf;
    private Data nascimento;

    public Pessoa(String nome, String cpf, Data nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Data getNascimento() {
        return nascimento;
    }

    public void imprimeDados() {
        System.out.println("Nome: " + nome + ", CPF: " + cpf + ", Nascimento: " + nascimento);
    }
}

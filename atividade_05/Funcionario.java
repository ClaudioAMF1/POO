public class Funcionario extends Pessoa {
    private float salario;

    public Funcionario(String nome, String cpf, Data nascimento, float salario) {
        super(nome, cpf, nascimento);
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    @Override
    public void imprimeDados() {
        super.imprimeDados();
        System.out.println("Salário: " + salario);
    }

    public float calculaImposto() {
        return salario * 0.05f;
    }
}

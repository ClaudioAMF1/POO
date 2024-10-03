public class Funcionario extends Pessoa {
    private float salario;

    public Funcionario(String nome, Data nascimento, float salario) {
        super(nome, nascimento);
        setSalario(salario);
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("O salário não pode ser negativo.");
        }
        this.salario = salario;
    }

    public float calculaImposto() {
        return salario * 0.03f; // Imposto de 3%
    }

    @Override
    public void imprimeDados() {
        System.out.println("Funcionário: " + getNome() + ", Salário: " + salario + ", Nascimento: " + getNascimento() + ", Imposto: " + calculaImposto());
    }
}

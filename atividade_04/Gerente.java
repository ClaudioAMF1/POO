public class Gerente extends Funcionario {
    private String area;

    public Gerente(String nome, Data nascimento, float salario, String area) {
        super(nome, nascimento, salario);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public float calculaImposto() {
        return getSalario() * 0.05f; // Imposto de 5% para gerente
    }

    @Override
    public void imprimeDados() {
        System.out.println("Gerente: " + getNome() + ", Área: " + area + ", Salário: " + getSalario() + ", Nascimento: " + getNascimento() + ", Imposto: " + calculaImposto());
    }
}

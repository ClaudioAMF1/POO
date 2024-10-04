public class Gerente extends Funcionario {
    private String area;

    public Gerente(String nome, String cpf, Data nascimento, float salario, String area) {
        super(nome, cpf, nascimento, salario);
        this.area = area;
    }

    @Override
    public void imprimeDados() {
        super.imprimeDados();
        System.out.println("Área: " + area);
    }

    @Override
    public float calculaImposto() {
        return getSalario() * 0.03f;
    }
}

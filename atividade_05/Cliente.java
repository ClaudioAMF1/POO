public class Cliente extends Pessoa {
    private int codigo;

    public Cliente(String nome, String cpf, Data nascimento, int codigo) {
        super(nome, cpf, nascimento);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public void imprimeDados() {
        super.imprimeDados();
        System.out.println("Código: " + codigo);
    }
}

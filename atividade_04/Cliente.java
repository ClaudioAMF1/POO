public class Cliente extends Pessoa {
    private int codigo;

    public Cliente(String nome, Data nascimento, int codigo) {
        super(nome, nascimento);
        setCodigo(codigo);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo < 0) {
            throw new IllegalArgumentException("O código não pode ser negativo.");
        }
        this.codigo = codigo;
    }

    @Override
    public void imprimeDados() {
        System.out.println("Cliente: " + getNome() + ", Código: " + codigo + ", Nascimento: " + getNascimento());
    }
}

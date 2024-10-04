public class ClienteVip extends Cliente {
    private double percentualDesconto;

    public ClienteVip(String nome, String cpf, Data nascimento, int codigo, double percentualDesconto) {
        super(nome, cpf, nascimento, codigo);
        this.percentualDesconto = percentualDesconto;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }
}

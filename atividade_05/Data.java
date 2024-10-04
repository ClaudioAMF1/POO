public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (dia < 1 || dia > 31) {
            throw new IllegalArgumentException("Dia inválido!");
        }
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mês inválido!");
        }
        if (ano < 1900 || ano > 2100) {  // Exemplo de limites para ano
            throw new IllegalArgumentException("Ano inválido!");
        }
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}

public class Cidade {
    private String nome;
    private String uf;
    private boolean capital;

    public Cidade(String nome, String uf, boolean capital) {
        this.nome = nome;
        this.uf = uf;
        this.capital = capital;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return nome + " - " + uf + (capital ? " (Capital)" : "");
    }
}
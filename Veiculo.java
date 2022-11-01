import java.util.ArrayList;

public abstract class Veiculo implements GetId {

    private int id;
    private String nome;
    private int idLocacao;
    private Locacao locacao;

    protected Veiculo(int id, String nome, Locacao locacao) {
        this.id = id;
        this.nome = nome;
        this.idLocacao = locacao.getId();
        this.locacao = locacao;

        locacao.setVeiculo(this);
        // this.alimentacoes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    // public ArrayList<Alimentacao> getAlimentacoes() {
    //     return alimentacoes;
    // }

    // public void setAlimentacoes(Alimentacao alimentacao) {
    //     this.alimentacoes.add(alimentacao);
    // }

    @Override
    public String toString() {
        return "Id=" + id + "\n"
            + "Nome=" + nome + "\n"
            + "Vaga=" + locacao.getNumero() + "\n";
    }

}
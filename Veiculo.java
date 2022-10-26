import java.util.ArrayList;

public abstract class Veiculo implements GetId {

    private int id;
    private String nome;
    private int idVaga;
    private Vaga vaga;

    protected Veiculo(int id, String nome, Vaga vaga) {
        this.id = id;
        this.nome = nome;
        this.idVaga = vaga.getId();
        this.vaga = vaga;

        vaga.setVeiculo(this);
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


    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
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
            + "Vaga=" + vaga.getNumero() + "\n";
    }

}
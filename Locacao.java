import java.util.ArrayList;

public class Locacao implements GetId {
    
    private int id;
    private String data;
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Vaga> vagas;
    
    private static ArrayList<Locacao> locacoes = new ArrayList<>();

    public Locacao(String data) {
        this.id = GetId.getNextId(locacoes);
        this.data = data;

        this.veiculos = new ArrayList<>();
        this.vagas = new ArrayList<>();


        locacoes.add(this);
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<Veiculo> getVeiculo() {
        return veiculos;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public ArrayList<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(Vaga vaga) {
        this.vagas.add(vaga);
    }

    public static ArrayList<Locacao> getLocacoes() {
        return locacoes;
    }

    public static Locacao getLocacao(int id) throws Exception {
        for (Locacao locacao : locacoes) {
            if (locacao.getId() == id) {
                return locacao;
            }
        }
        throw new Exception("Locação não encontrada");
    }

    public static void removeLocacao(int id) throws Exception {
        Locacao locacao = getLocacao(id);
        locacoes.remove(locacao);
    }

    @Override
    public String toString() {
        return "Id=" + id + "\n"
            + "Data=" + data + "\n";
    }

}

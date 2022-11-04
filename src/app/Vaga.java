package src.app;
import java.util.ArrayList;

public class Vaga implements GetId {
    
    private int id;
    private Chave<String, Integer> codVaga;
    private String tipoVaga;
    private String tamanho;
    private double preco;
    private ArrayList<Locacao> locacoes;

    private static ArrayList<Vaga> vagas = new ArrayList<>();

    public Vaga(
        String letraVaga,
        int numerosVaga,
        String tipoVaga, 
        String tamanho, 
        Double preco)
        {
        this.id = GetId.getNextId(vagas);
        this.setCodVaga(letraVaga, numerosVaga);
        this.tipoVaga = tipoVaga;
        this.tamanho = tamanho;
        this.preco = preco;

        this.locacoes = new ArrayList<>();

        vagas.add(this);
    }

    public int getId() {
        return id;
    }

    public Chave<String, Integer> getCodVaga() {
        return codVaga;
    }

    public String getTipo() {
        return tipoVaga;
    }

    public String getTamanho() {
        return tamanho;
    }
    public double getPreco() {
        return preco;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setCodVaga(String letraVaga, int numerosVaga) {
        this.codVaga = new Chave<String,Integer>(letraVaga, numerosVaga);
    }

    public void setTipo(String tipoVaga) {
        this.tipoVaga = tipoVaga;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }   

    public void setLocacoes(Locacao locacao) {
        this.locacoes.add(locacao);
    } 

    public static ArrayList<Vaga> getVagas() {
        return vagas;
    }


    public static Vaga getVaga(int id) throws Exception {
        for (Vaga vaga : vagas) {
            if (vaga.getId() == id) {
                return vaga;
            }
        }
        throw new Exception("Vaga não encontrada");
    }

    public static void removeVaga(int id) throws Exception {
        Vaga vaga = getVaga(id);
        vagas.remove(vaga);
    }

    @Override
    public String toString() {
        return "Id= " + id + "\n"
            + "Codigo= " + codVaga + "\n"
            + "Tipo= " + tipoVaga + "\n"
            + "Tamanho= " + tamanho + "\n"
            + "Preco= " + preco + "\n";
    }

}

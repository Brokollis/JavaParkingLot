import java.util.ArrayList;

public class Vaga implements GetId {
    
    private int id;
    private Chave<String, Integer> placaCarro;
    private String tipoVaga;
    private String tamanho;
    private double preco;
    private ArrayList<Locacao> locacoes;

    private static ArrayList<Vaga> vagas = new ArrayList<>();

    public Vaga(int letraVaga,numerosVaga, String tipoVaga, String tamanho, Double preco) {
        this.id = GetId.getNextId(vagas);
        this.setPlacaCarro(placaLetra, placaNumero);
        this.numero = numero;
        this.tipoVaga = tipoVaga;
        this.tamanho = tamanho;
        this.preco = preco;

        this.locacoes = new ArrayList<>();

        vagas.add(this);
    }

    public int getId() {
        return id;
    }

    public int getNumero() {
        return numero;
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

    public void setNumero(int numero) {
        this.numero = numero;
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
            + "Numero= " + numero + "\n"
            + "Tipo= " + tipoVaga + "\n"
            + "Tamanho= " + tamanho + "\n"
            + "Preco= " + preco + "\n";
    }

}

import java.util.ArrayList;

public class Limpeza implements GetId {
    
    private int id;
    private String data;
    private String descricao;
    private int idJaula;
    private Jaula jaula;
    
    private static ArrayList<Limpeza> limpezas = new ArrayList<>();

    public Limpeza(String data, String descricao, Jaula jaula) {
        this.id = GetId.getNextId(limpezas);
        this.data = data;
        this.descricao = descricao;
        this.idJaula = jaula.getId();
        this.jaula = jaula;

        jaula.setLimpezas(this);
        limpezas.add(this);
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Jaula getJaula() {
        return jaula;
    }

    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }

    public static ArrayList<Limpeza> getLimpezas() {
        return limpezas;
    }

    public static Limpeza getLimpeza(int id) throws Exception {
        for (Limpeza limpeza : limpezas) {
            if (limpeza.getId() == id) {
                return limpeza;
            }
        }
        throw new Exception("Limpeza não encontrada");
    }

    public static void removeLimpeza(int id) throws Exception {
        Limpeza limpeza = getLimpeza(id);
        limpezas.remove(limpeza);
    }

    @Override
    public String toString() {
        return "Id=" + id + "\n"
            + "Data=" + data + "\n"
            + "Descricao=" + descricao + "\n"
            + "Jaula=" + jaula.getNome() + "\n";
    }

}

package src.app;
import java.util.ArrayList;

public class Moto extends Veiculo {

    private Chave<String, Integer> placaMoto;
    private int cilindrada;

    private static ArrayList<Moto> motos = new ArrayList<>();
    
    public Moto(
        String nome,
        String placaLetra,
        int placaNumero,
        int cilindrada
    ) {
        super(GetId.getNextId(motos), nome);
        this.setPlacaMoto(placaLetra, placaNumero);
        this.cilindrada = cilindrada;

        motos.add(this);
    }
    
    public Chave<String, Integer> getPlacaMoto() {
        return placaMoto;
    }
    
    private void setPlacaMoto(String placaLetra, int placaNumero) {
        this.placaMoto = new Chave<String,Integer>(placaLetra, placaNumero);
    }

    public int getCilindrada() {
        return cilindrada;
    }
    
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    public static ArrayList<Moto> getMotos() {
        return motos;
    }

    public static Moto getMoto(int id) throws Exception {
        for (Moto moto : motos) {
            if (moto.getId() == id) {
                return moto;
            }
        }
        throw new Exception("moto não encontrada");
    }

    public static void removeMoto(int id) throws Exception {
        Moto moto = getMoto(id);
        motos.remove(moto);
    }
    
    @Override
    public String toString() {
        return super.toString() 
        + "Placa da moto = " + placaMoto + "\n"
            + "Cilindrada = " + cilindrada;
    }
}

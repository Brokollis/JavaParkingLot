import java.util.ArrayList;

public class Moto extends Veiculo {

    private String placaMoto;
    private int cilindrada;

    private static ArrayList<Moto> motos = new ArrayList<>();
    
    public Moto(
        String nome,
        Locacao locacao,      
        String placaMoto,
        int cilindrada
    ) {
        super(GetId.getNextId(motos), nome, locacao);
        this.placaMoto = placaMoto;
        this.cilindrada = cilindrada;

        motos.add(this);
    }
    
    public String getPlacaMoto() {
        return placaMoto;
    }
    
    public void setPlacaMoto(String placaMoto) {
        this.placaMoto = placaMoto;
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
        + "Placa da moto =" + placaMoto + "\n"
            + "Cilindrada =" + cilindrada;
    }
}

import java.util.ArrayList;

public class Bicicleta extends Veiculo {

    private String marcaBike;
    private String corBike;

    private static ArrayList<Bicicleta> bicicletas = new ArrayList<>();
    
    public Bicicleta(
        String nome,
        Vaga vaga,      
        String marcaBike,
        String corBike
    ) {
        super(GetId.getNextId(bicicletas), nome, vaga);
        this.marcaBike = marcaBike;
        this.corBike = corBike;

        veiculos.add(this);
    }
    
    public String getMarcaBike() {
        return marcaBike;
    }
    
    public void setMarcaBike(String marcaBike) {
        this.marcaBike = marcaBike;
    }

    public String getCorBike() {
        return corBike;
    }
    
    public void setCorBike(String corBike) {
        this.corBike = corBike;
    }
    public static ArrayList<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    public static Bicicleta getBicicleta(int id) throws Exception {
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta.getId() == id) {
                return bicicleta;
            }
        }
        throw new Exception("bicleta não encontrada");
    }

    public static void removeBicicleta(int id) throws Exception {
        Bicicleta bicicleta = getBicicleta(id);
        bicicletas.remove(bicicleta);
    }
    
    @Override
    public String toString() {
        return super.toString() + "Marca da bicicleta =" + marcaBike + "\n";
    }
    public String toString() {
        return super.toString() + "Cor da bicicleta=" + corBike + "\n";
    }
}

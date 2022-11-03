import java.util.ArrayList;

public class Carro extends Veiculo {

    private String placaCarro;
    private String corCarro;    

    private static ArrayList<Carro> carros = new ArrayList<>();
    
    public Carro(
        String nome,
        String placaCarro,
        String corCarro
    ) {
        super(GetId.getNextId(carros), nome);
        this.placaCarro = placaCarro;
        this.corCarro = corCarro;

        carros.add(this);
    }
    
    public String getPlacaCarro() {
        return placaCarro;
    }
    
    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public String getCorCarro() {
        return corCarro;
    }
    
    public void setCorCarro(String corCarro) {
        this.corCarro = corCarro;
    }
    public static ArrayList<Carro> getCarros() {
        return carros;
    }

    public static Carro getCarro(int id) throws Exception {
        for (Carro carro : carros) {
            if (carro.getId() == id) {
                return carro;
            }
        }
        throw new Exception("Carro não encontrado");
    }

    public static void removeCarro(int id) throws Exception {
        Carro carro = getCarro(id);
        carros.remove(carro);
    }
    
    @Override
    public String toString() {
        return super.toString()
        + "Placa do carro=" + placaCarro + "\n "
            + "Cor do carro=" + corCarro + "\n ";
    }

}

import java.util.ArrayList;

public class Carro extends Veiculo {

    private Chave<String, Integer> placaCarro;
    private String corCarro;    

    private static ArrayList<Carro> carros = new ArrayList<>();
    
    public Carro(
        String nome,
        String placaLetra,
        int placaNumero,
        String corCarro
    ) {
        super(GetId.getNextId(carros), nome);
        this.setPlacaCarro(placaLetra, placaNumero);
        this.setCorCarro(corCarro);

        carros.add(this);
    }
    
    public Chave<String, Integer> getPlacaCarro() {
        return placaCarro;
    }
    
    private void setPlacaCarro(String placaLetra, int placaNumero) {
        this.placaCarro = new Chave<String,Integer>(placaLetra, placaNumero);
    }

    public String getCorCarro() {
        return corCarro;
    }
    
    private void setCorCarro(String corCarro) {
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

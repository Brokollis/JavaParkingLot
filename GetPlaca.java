import java.util.ArrayList;

public interface GetPlaca {

    public String getPlaca();

    public static int getNextPlaca(ArrayList<? extends GetPlaca> lista) {
        String placa = "ABC-";
        for (GetPlaca object : lista) {
            if (object.getPlaca() > placa) {
                placa = object.getPlaca();
            }
        }
        return  + 1;
    }
}

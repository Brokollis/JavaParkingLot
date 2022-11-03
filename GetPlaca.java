import java.util.ArrayList;
import java.util.Random;


public interface GetPlaca {

    // public static String letRandom(){
    //     String letras = "";
    //     letras = new letras= Math.random().toString(26).substring(2);
    //     letra = letra.substring(0, letra.length());

    // }
    public static void getRandom(){
        Random ale = new Random();
        int letra = ale.nextInt();
        letra = toString(36).letra.substring(2);
        System.out.println("Valor Gerado: " + letra);
    }

//     public String getPlaca();

//     public static int getNextPlaca(ArrayList<? extends GetPlaca> lista) {
//         String placa = "ABC-";
//         for (GetPlaca object : lista) {
//             if (object.getPlaca() > placa) {
//                 placa = object.getPlaca();
//             }
//         }
//         return  + 1;
//     }
}

public class Chave<S, N extends Number> {
    private S letras;
    private N numeros;

    public Chave(S letras, N numeros) {
        this.letras = letras;
        this.numeros = numeros;
    }

    @Override
    public String toString() {
        return letras + "-" + numeros;
    }

   
}


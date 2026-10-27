public class Lugar {
    private char fila;
    int numero;

    public Lugar(char fila, int numero) {
        this.fila = Character.toUpperCase(fila);
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Fila " + fila +
                ", Lugar " + numero;
    }

    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero > 0)
            this.numero = numero;
    }
}

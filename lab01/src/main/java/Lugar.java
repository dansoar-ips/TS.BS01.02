import java.util.Objects;

public class Lugar {
    private char fila;
    private int numero;

    public Lugar(char fila, int numero) {
        this.fila = Character.toUpperCase(fila);
        this.numero = numero;
    }

    public char getFila() {
        return fila;
    }

    public int getNumero() {return numero;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lugar lugar = (Lugar) o;
        return fila == lugar.fila && numero == lugar.numero;
    }



    @Override
    public int hashCode() {
        return Objects.hash(fila, numero);
    }

    @Override
    public String toString() {
        return "" + fila + numero;
    }
}
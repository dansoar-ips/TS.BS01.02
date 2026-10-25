public class Cliente {
    String numero;

    public Cliente(String numero) {
        setNumero(numero);
    }

    @Override
    public String toString() {
        return "Cliente nº " + numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero != null && !numero.isEmpty())
            this.numero = numero;
    }
}

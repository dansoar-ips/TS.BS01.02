import java.util.ArrayList;
import java.util.List;

public class Sala {
    private int numero;
    //lista porque é  multiplicidade de 0*
    private List<Lugar> lugares;

    public Sala(int numero) {
        setNumero(numero);
        this.lugares = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Sala " + numero +
                ", (Total de lugares " + lugares.size() +
                ')';
    }

    /**
     * Função para adicionar lugares à sala (pode conter 0 ou muitos)
     * @param fila fila da sala
     * @param numeroLugar numero do lugar
     * É criado aqui o objeto (new Lugar) para ter a composição forte
     * desta forma, ao apagar o objeto da sala, os lugares associados
     * também são apagados (pois foram criados dentro da classe)
     */
    public void adicionarLugar(char fila, int numeroLugar) {
        Lugar novoLugar = new Lugar(fila, numeroLugar);
        this.lugares.add(novoLugar);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero > 0)
            this.numero = numero;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }
}

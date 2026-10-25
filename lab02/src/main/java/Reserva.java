import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private int id;
    private Cliente cliente;
    private Sessao sessao;
    private List <Lugar> lugares; // mult. 0*


    public Reserva(int id, Cliente cliente, Sessao sessao) {
        setId(id);
        setCliente(cliente);
        setSessao(sessao);
        this.lugares = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Reserva #" + id + "\n" +
                " - " + cliente + "\n" +
                " - " + sessao + "\n" +
                " - Lugares: " + lugares;
    }

    public void adicionarLugar(Lugar lugar) {
        if (!this.lugares.contains(lugar)) // se não houver um lugar igual ao que queres colocar
            this.lugares.add(lugar);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0)
            this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente != null)
            this.cliente = cliente;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        if (sessao != null)
            this.sessao = sessao;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

}



import java.util.List;

public class Reserva {
    private String telefoneCliente;
    private Sessao sessao;
    private List<Lugar> lugaresReservados;

    public Reserva(String telefoneCliente, Sessao sessao, List<Lugar> lugaresReservados) {
        this.telefoneCliente = telefoneCliente;
        this.sessao = sessao;
        this.lugaresReservados = lugaresReservados;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public List<Lugar> getLugaresReservados() {
        return lugaresReservados;
    }

    @Override
    public String toString() {
        return "Reserva {" +
                "Cliente (Tel)='" + telefoneCliente + '\'' +
                ", Filme='" + sessao.getNomeFilme() + '\'' +
                ", Sala=" + sessao.getNumeroSala() +
                ", Data/Hora=" + sessao.getData() + " às " + sessao.getHora() +
                ", Lugares=" + lugaresReservados +
                '}';
    }
}
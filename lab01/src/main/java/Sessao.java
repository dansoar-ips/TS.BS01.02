import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sessao {
    private LocalDate data;
    private LocalTime hora;
    private String nomeFilme;
    private int numeroSala;
    
    // Conjunto de lugares já ocupados nesta sessão específica
    private Set<Lugar> lugaresOcupados;

    public Sessao(LocalDate data, LocalTime hora, String nomeFilme, int numeroSala) {
        this.data = data;
        this.hora = hora;
        this.nomeFilme = nomeFilme;
        this.numeroSala = numeroSala;
        this.lugaresOcupados = new HashSet<>();
    }

    /**
     * Verifica se um determinado lugar já se encontra ocupado nesta sessão.
     */
    public boolean estaOcupado(Lugar lugar) {
        return lugaresOcupados.contains(lugar);
    }

    /**
     * Tenta reservar uma lista de lugares para esta sessão.
     * Retorna true se a reserva for bem-sucedida, ou false se algum já estiver ocupado.
     */
    public boolean ocuparLugares(List<Lugar> lugaresParaReservar) {
        // 1. Verificar se algum dos lugares pretendidos já está ocupado
        for (Lugar lugar : lugaresParaReservar) {
            if (estaOcupado(lugar)) {
                return false; // Conflito: lugar já ocupado
            }
        }

        // 2. Se todos estiverem livres, efetuamos a ocupação definitiva
        lugaresOcupados.addAll(lugaresParaReservar);
        return true;
    }

    // Getters
    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public Set<Lugar> getLugaresOcupados() {
        return lugaresOcupados;
    }
}
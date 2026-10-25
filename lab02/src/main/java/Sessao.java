import java.time.LocalDate;
import java.time.LocalDateTime;

public class Sessao {
    private String nomeFilme;
    private LocalDateTime dataHora;
    private Sala sala;


    @Override
    public String toString() {
        return "Sessão: " + nomeFilme +
                " | Data/Hora: " + dataHora +
                " | " + sala;
    }

    public Sessao(String nomeFilme, LocalDateTime dataHora, Sala sala) {
        setNomeFilme(nomeFilme);
        setDataHora(dataHora);
        setSala(sala);
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        if (nomeFilme != null && !nomeFilme.isEmpty())
            this.nomeFilme = nomeFilme;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        if (dataHora != null)
            this.dataHora = dataHora;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        if (sala != null)
            this.sala = sala;
    }
}

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Criar uma sessão de cinema
        Sessao sessao = new Sessao(LocalDate.of(2026, 6, 15), LocalTime.of(21, 30), "Inception", 2);

        // 2. O cliente escolhe um conjunto de lugares (ex: Fila A, lugares 1, 2 e 3)
        List<Lugar> lugaresPretendidos = Arrays.asList(
            new Lugar('A', 1),
            new Lugar('A', 2),
            new Lugar('A', 3)
        );

        // 3. Validação 1: Verificar se os lugares são adjacentes
        boolean saoAdjacentes = ValidadorReserva.saoAdjacentes(lugaresPretendidos);
        
        if (!saoAdjacentes) {
            System.out.println("Erro: Os lugares solicitados não são adjacentes na mesma fila.");
            return;
        }

        // 4. Validação 2: Tentar ocupar os lugares na sessão (verifica conflitos com outras reservas)
        boolean lugaresOcupadosComSucesso = sessao.ocuparLugares(lugaresPretendidos);

        if (!lugaresOcupadosComSucesso) {
            System.out.println("Erro: Um ou mais lugares já se encontram ocupados nesta sessão.");
            return;
        }

        // 5. Se tudo estiver correto, cria-se efetivamente a Reserva
        Reserva novaReserva = new Reserva("912345678", sessao, lugaresPretendidos);
        
        System.out.println("Reserva efetuada com sucesso!");
        System.out.println(novaReserva);
    }
}
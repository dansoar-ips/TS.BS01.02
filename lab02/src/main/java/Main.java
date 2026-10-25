import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        //----Clientes----
        Cliente c1 = new Cliente("0001");
        Cliente c2 = new Cliente("0002");

        //----Salas----
        Sala sala1 = new Sala(1);
        Sala sala2 = new Sala(2);

        //Adicionar lugares à sala (associação forte)
        sala1.adicionarLugar('A', 1);
        sala1.adicionarLugar('A', 2);

        sala2.adicionarLugar('B', 1);
        sala2.adicionarLugar('B', 2);

        //----Sessões----
        Sessao sessao1 = new Sessao("Daniel o Aventureiro", LocalDateTime.of(2026, 11, 13, 15, 0), sala1);
        Sessao sessao2 = new Sessao("The life of Fertagus", LocalDateTime.of(2026, 11, 22, 20, 30), sala2);

        //----Reservas----
        Reserva r1 = new Reserva(1, c1, sessao1);
        Reserva r2 = new Reserva(2, c2, sessao2);

        //----Reservar Lugares----
        r1.adicionarLugar(sala1.getLugares().get(0));

        r2.adicionarLugar(sala2.getLugares().get(0));
        r2.adicionarLugar(sala2.getLugares().get(1));

        //----Imprimir detalhes das reservas:
        System.out.println("Detalhes das reservas: ");
        System.out.println(r1);
        System.out.println(r2);


    }



}

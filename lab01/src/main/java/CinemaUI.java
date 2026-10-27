import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaUI {
    private static List<Sessao> sessoes = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializar com algumas sessões de exemplo
        inicializarDados();

        int opcao = 0;
        do {
            exibirMenu();
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
                processarOpcao(opcao);
            } else {
                System.out.println("Opção inválida. Insira um número.");
                scanner.nextLine(); // Limpar input inválido
            }
        } while (opcao != 0);

        System.out.println("A encerrar o sistema de cinema. Até breve!");
    }

    private static void inicializarDados() {
        sessoes.add(new Sessao(LocalDate.of(2026, 6, 15), LocalTime.of(21, 30), "Inception", 1));
        sessoes.add(new Sessao(LocalDate.of(2026, 6, 15), LocalTime.of(22, 00), "The Matrix", 2));
    }

    private static void exibirMenu() {
        System.out.println("\n===== SISTEMA DE RESERVAS DE CINEMA =====");
        System.out.println("1. Listar Sessões Disponíveis");
        System.out.println("2. Efetuar Nova Reserva");
        System.out.println("3. Consultar Reservas Registadas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                listarSessoes();
                break;
            case 2:
                efetuarReserva();
                break;
            case 3:
                listarReservas();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção desconhecida. Tente novamente.");
        }
    }

    private static void listarSessoes() {
        System.out.println("\n--- Sessões Disponíveis ---");
        for (int i = 0; i < sessoes.size(); i++) {
            Sessao s = sessoes.get(i);
            System.out.println((i + 1) + ". Filme: " + s.getNomeFilme() + 
                               " | Sala: " + s.getNumeroSala() + 
                               " | Data: " + s.getData() + " às " + s.getHora() +
                               " | Lugares Ocupados: " + s.getLugaresOcupados().size());
        }
    }

    private static void efetuarReserva() {
        listarSessoes();
        System.out.print("Selecione o número da sessão pretendida: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Sessão inválida.");
            scanner.nextLine();
            return;
        }
        int indiceSessao = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indiceSessao < 0 || indiceSessao >= sessoes.size()) {
            System.out.println("Erro: Sessão inexistente.");
            return;
        }

        Sessao sessaoEscolhida = sessoes.get(indiceSessao);

        System.out.print("Insira o número de telefone do cliente: ");
        String telefone = scanner.nextLine();

        System.out.print("Insira os lugares pretendidos (ex: A1,A2,A3): ");
        String inputLugares = scanner.nextLine();

        // Converter a string em lista de objetos Lugar (ex: "A1,A2" -> Lugar('A',1), Lugar('A',2))
        List<Lugar> lugaresPretendidos = new ArrayList<>();
        try {
            String[] tokens = inputLugares.split(",");
            for (String token : tokens) {
                token = token.trim().toUpperCase();
                char fila = token.charAt(0);
                int numero = Integer.parseInt(token.substring(1));
                lugaresPretendidos.add(new Lugar(fila, numero));
            }
        } catch (Exception e) {
            System.out.println("Erro no formato dos lugares. Use o formato FilaNúmero separado por vírgulas (ex: A1,A2).");
            return;
        }

        // 1. Validar se são adjacentes
        if (!ValidadorReserva.saoAdjacentes(lugaresPretendidos)) {
            System.out.println("❌ Falha na reserva: Os lugares solicitados não são adjacentes na mesma fila.");
            return;
        }

        // 2. Tentar ocupar na sessão
        boolean sucessoOcupacao = sessaoEscolhida.ocuparLugares(lugaresPretendidos);
        if (!sucessoOcupacao) {
            System.out.println("❌ Falha na reserva: Um ou mais lugares já se encontram ocupados nesta sessão.");
            return;
        }

        // 3. Criar e registar a reserva
        Reserva novaReserva = new Reserva(telefone, sessaoEscolhida, lugaresPretendidos);
        reservas.add(novaReserva);

        System.out.println("✅ Reserva efetuada com sucesso!");
        System.out.println(novaReserva);
    }

    private static void listarReservas() {
        System.out.println("\n--- Reservas Registadas no Sistema ---");
        if (reservas.isEmpty()) {
            System.out.println("Não existem reservas efetuadas.");
            return;
        }
        for (Reserva r : reservas) {
            System.out.println("- " + r);
        }
    }
}
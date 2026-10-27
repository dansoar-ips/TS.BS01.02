import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidadorReserva {

    public static boolean saoAdjacentes(List<Lugar> lugares) {
        if (lugares == null || lugares.isEmpty()) {
            return false;
        }
        if (lugares.size() == 1) {
            return true; // Um único lugar é sempre "adjacente" a si próprio
        }

        // 1. Validar se todos partilham exatamente a mesma fila
        char filaReferencia = lugares.get(0).getFila();
        for (Lugar lugar : lugares) {
            if (lugar.getFila() != filaReferencia) {
                return false; // Estão em filas diferentes
            }
        }

        // 2. Extrair os números e ordená-los para verificar a continuidade
        List<Integer> numeros = new ArrayList<>();
        for (Lugar lugar : lugares) {
            numeros.add(lugar.getNumero());
        }
        Collections.sort(numeros);

        // 3. Verificar se a diferença entre elementos consecutivos é estritamente 1
        for (int i = 0; i < numeros.size() - 1; i++) {
            if (numeros.get(i + 1) != numeros.get(i) + 1) {
                return false; // Há uma falha na continuidade (ex: lugares 3 e 5, falta o 4)
            }
        }

        return true;
    }
}
import java.util.ArrayList;
import java.util.List;

public class Lab {
    private String name;
    private List<Computer> computers;

    public Lab(String name) {
        this.name = name;
        this.computers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Computer> getComputers() {
        return List.copyOf(computers); // Devolve cópia imutável[cite: 1, 2]
    }

    /**
     * Adiciona um computador garantindo a unicidade de ID no laboratório.
     */
    public boolean addComputer(Computer c) {
        if (c == null) {
            return false;
        }
        for (Computer comp : computers) {
            if (comp.getId().equals(c.getId())) {
                return false;
            }
        }
        computers.add(c);
        return true;
    }

    /**
     * Pesquisa um computador pelo ID[cite: 2].
     */
    public Computer findComputerById(String id) {
        if (id == null) {
            return null;
        }
        for (Computer comp : computers) {
            if (comp.getId().equals(id)) {
                return comp;
            }
        }
        return null;
    }

    /**
     * Remove um computador pelo ID e devolve a instância removida[cite: 2].
     */
    public Computer removeComputer(String id) {
        if (id == null) {
            return null;
        }
        for (int i = 0; i < computers.size(); i++) {
            Computer comp = computers.get(i);
            if (comp.getId().equals(id)) {
                return computers.remove(i);
            }
        }
        return null;
    }
}
import java.util.ArrayList;
import java.util.List;

public class Component {
    private String id;
    private String name;
    private List<Component> parts;

    public Component(String id, String name) {
        this.id = id;
        this.name = name;
        this.parts = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Component> getParts() {
        return List.copyOf(parts); // Devolve cópia imutável[cite: 1, 3]
    }

    /**
     * Deteção de ciclos e pesquisa de ID na subárvore[cite: 3].
     */
    public boolean containsId(String id) {
        if (id == null) {
            return false;
        }
        if (this.id.equals(id)) {
            return true;
        }
        for (Component part : parts) {
            if (part.containsId(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona um subcomponente ao mesmo nível[cite: 3].
     */
    public boolean addPart(Component child) {
        if (child == null) {
            return false;
        }

        // Unicidade de ID entre os subcomponentes no mesmo nível[cite: 1, 3]
        for (Component part : parts) {
            if (part.getId().equals(child.getId())) {
                return false;
            }
        }

        // Prevenção de ciclos na hierarquia[cite: 1, 3]
        if (child.containsId(this.id)) {
            return false;
        }

        parts.add(child);
        return true;
    }

    /**
     * Remove um subcomponente direto pelo ID[cite: 3].
     */
    public Component removePart(String childId) {
        if (childId == null) {
            return null;
        }
        for (int i = 0; i < parts.size(); i++) {
            Component part = parts.get(i);
            if (part.getId().equals(childId)) {
                return parts.remove(i);
            }
        }
        return null;
    }

    /**
     * Conta recursivamente todos os descendentes (filhos, netos, etc.)[cite: 4].
     */
    public int countDescendants() {
        int total = parts.size();
        for (Component part : parts) {
            total += part.countDescendants();
        }
        return total;
    }
}
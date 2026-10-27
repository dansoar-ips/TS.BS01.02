import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String id;
    private String brand;
    private List<Component> components;

    public Computer(String id, String brand) {
        this.id = id;
        this.brand = brand;
        this.components = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public List<Component> getComponents() {
        return List.copyOf(components); // Devolve cópia imutável[cite: 1, 3]
    }

    /**
     * Adiciona um componente no nível de topo do computador[cite: 3].
     */
    public boolean addComponent(Component c) {
        if (c == null) {
            return false;
        }
        // Unicidade de ID entre componentes de topo[cite: 1, 3]
        for (Component comp : components) {
            if (comp.getId().equals(c.getId())) {
                return false;
            }
        }
        components.add(c);
        return true;
    }

    /**
     * Remove um componente de topo pelo seu ID[cite: 3].
     */
    public Component removeComponent(String id) {
        if (id == null) {
            return null;
        }
        for (int i = 0; i < components.size(); i++) {
            Component comp = components.get(i);
            if (comp.getId().equals(id)) {
                return components.remove(i);
            }
        }
        return null;
    }

    /**
     * Conta o total de componentes (componentes de topo + todos os seus descendentes)[cite: 4].
     */
    public int countAllComponents() {
        int total = components.size();
        for (Component comp : components) {
            total += comp.countDescendants();
        }
        return total;
    }
}
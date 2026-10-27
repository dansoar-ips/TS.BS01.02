import java.util.ArrayList;
import java.util.List;

public class Institution {
    private String name;
    private List<Lab> labs;

    public Institution(String name) {
        this.name = name;
        this.labs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Lab> getLabs() {
        return List.copyOf(labs); // Devolve cópia imutável[cite: 1, 2]
    }

    /**
     * Adiciona um laboratório garantindo unicidade do nome na instituição[cite: 1, 2].
     */
    public boolean addLab(Lab lab) {
        if (lab == null) {
            return false;
        }
        for (Lab l : labs) {
            if (l.getName().equalsIgnoreCase(lab.getName())) {
                return false;
            }
        }
        labs.add(lab);
        return true;
    }
}
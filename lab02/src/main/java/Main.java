public class Main {
    public static void main(String[] args) {
        // --- NÍVEL 2: Instituição e Laboratórios ---[cite: 2]
        Institution ips = new Institution("IPS");
        Lab labRedes = new Lab("LabRedes");
        Lab labProg1 = new Lab("LabProgramacao1");
        Lab LabProg2 = new Lab("LabProgramacao2");

        ips.addLab(labRedes);
        ips.addLab(labProg1);
        ips.addLab(LabProg2);

        System.out.println("Total de Laboratórios no IPS: " + ips.getLabs().size()); // Esperado: 3

        // --- NÍVEL 3: Computadores no Laboratório ---[cite: 2, 3]
        Computer pc1 = new Computer("PC1", "Dell");
        Computer pc2 = new Computer("PC2", "HP");

        labProg1.addComputer(pc1);
        labProg1.addComputer(pc2);

        System.out.println("Computadores em LabProgramacao1: " + labProg1.getComputers().size()); // Esperado: 2
        System.out.println("Pesquisa de PC1: " + labProg1.findComputerById("PC1").getBrand());

        // --- NÍVEL 4: Hierarquia de Componentes ---[cite: 3, 4]
        // Componentes de Topo do PC1[cite: 4]
        Component motherboard = new Component("C1", "Motherboard");
        Component ssd = new Component("C5", "SSD");
        Component powerSupply = new Component("C6", "PowerSupply");

        pc1.addComponent(motherboard);
        pc1.addComponent(ssd);
        pc1.addComponent(powerSupply);

        // Subcomponentes da Motherboard[cite: 4]
        Component cpu = new Component("C2", "CPU");
        Component ram = new Component("C3", "RAM");

        motherboard.addPart(cpu);
        motherboard.addPart(ram);

        // Subcomponente do CPU[cite: 4]
        Component cache = new Component("C4", "Cache");
        cpu.addPart(cache);

        // --- NÍVEL 5: Consultas ---[cite: 4]
        // countDescendants() na Motherboard (esperado: CPU, RAM, Cache = 3)[cite: 4]
        System.out.println("Descendentes da Motherboard: " + motherboard.countDescendants());

        // countAllComponents() no PC1 (esperado: 3 topo + 3 descendentes = 6)[cite: 4]
        System.out.println("Total de componentes no PC1: " + pc1.countAllComponents());
    }
}
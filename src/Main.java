public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("=== SIMULACAO DE HYPERVISOR COM THREADS ===");

            Hypervisor hypervisor = new Hypervisor();

            // Criando multiplas VMs
            VirtualMachine vm1 = new VirtualMachine("VM1");
            VirtualMachine vm2 = new VirtualMachine("VM2");
            VirtualMachine vm3 = new VirtualMachine("VM3");

            hypervisor.addVM(vm1);
            hypervisor.addVM(vm2);
            hypervisor.addVM(vm3);

            hypervisor.simulate();

            System.out.println("\n=== SIMULAÇÃO CONCLUÍDA ===");

        } catch (Exception e) {
            System.err.println("[Erro] Ocorreu um problema durante a simulação: " + e.getMessage());
            for (StackTraceElement element : e.getStackTrace()) {
                System.err.println("  at " + element);
            }
        }
    }
}
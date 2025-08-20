public class Main {
    public static void main(String[] args) {
        try {
            Hypervisor hypervisor = new Hypervisor();

            VirtualMachine vm1 = new VirtualMachine("VM1");
            VirtualMachine vm2 = new VirtualMachine("VM2");

            hypervisor.addVM(vm1);
            hypervisor.addVM(vm2);

            hypervisor.simulate();
        } catch (Exception e) {
            System.err.println("[Erro] Ocorreu um problema durante a simulação: " + e.getMessage());
            for (StackTraceElement element : e.getStackTrace()) {
                System.err.println("  at " + element);
            }
        }
    }
}

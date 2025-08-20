/**
 * Representa o Hipervisor Nativo.
 * Gerencia múltiplas VMs e orquestra a simulação.
 */
class Hypervisor {
    private final java.util.List<VirtualMachine> vms = new java.util.ArrayList<>();

    /**
     * Adiciona uma Máquina Virtual sob controle do Hipervisor.
     * @param vm VM a ser adicionada
     */
    public void addVM(VirtualMachine vm) {
        vms.add(vm);
    }

    /**
     * Executa a simulação de chamadas de sistema
     * em duas VMs ativas.
     */
    public void simulate() {
        if (vms.size() >= 2) {
            vms.get(0).requestNetworkAccess("Hello from network to VM1");
            System.out.println("\n--------------------------------------------------\n");
            vms.get(1).requestNetworkAccess("Ping request to VM2");
        }
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Representa o Hipervisor Nativo.
 * Gerencia multiplas VMs e orquestra a simulacao.
 */
class Hypervisor {
    private final List<VirtualMachine> vms = new ArrayList<>();
    private final NetworkCard physicalNetworkCard;

    public Hypervisor() {
        this.physicalNetworkCard = new NetworkCard();
    }

    /**
     * Adiciona uma Maquina Virtual sob controle do Hipervisor.
     * @param vm VM a ser adicionada
     */
    public void addVM(VirtualMachine vm) {
        vm.setNetworkCard(physicalNetworkCard);
        vms.add(vm);
    }

    /**
     * Executa a simulacao de chamadas de sistema
     * em VMs ativas em threads separadas.
     */
    public void simulate() {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < vms.size(); i++) {
            final int vmIndex = i;
            Thread thread = new Thread(() -> {
                try {
                    // Simula chegada aleatoria de pacotes
                    Random random = new Random();
                    Thread.sleep(random.nextInt(1000)); // Espera aleatoria

                    String message = "Pacote para " + vms.get(vmIndex).getName() +
                            " - ID: " + random.nextInt(1000);
                    vms.get(vmIndex).requestNetworkAccess(message);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            threads.add(thread);
        }

        // Inicia todas as threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Aguarda todas as threads terminarem
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
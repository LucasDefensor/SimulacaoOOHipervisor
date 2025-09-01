import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class NetworkCard {
    private final Lock lock = new ReentrantLock();

    /**
     * Processa dados recebidos de forma thread-safe.
     * @param vmName Nome da VM que esta recebendo os dados
     * @param data Dados recebidos
     */
    public void receiveData(String vmName, String data) {
        // REGIAO CRITICA - linha abaixo condicao de corrida
        // lock.lock();
        System.out.println("[NetworkCard - Física] Recebendo pacote para " + vmName + ": " + data);

        // Simula processamento que pode ser interrompido
        try {
            Thread.sleep(100); // Tempo de processamento
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
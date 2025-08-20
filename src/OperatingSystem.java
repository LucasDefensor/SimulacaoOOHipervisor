/**
 * Representa o Sistema Operacional de uma Máquina Virtual.
 * Possui dois modos:
 * - Usuário (gera chamadas de sistema)
 * - Núcleo (trata chamadas via handleSystemCall)
 */
class OperatingSystem {
    private final String name;

    public OperatingSystem(String name) {
        this.name = name;
    }

    /**
     * Trata chamadas de sistema encaminhadas pela VM.
     * @param call Objeto SystemCall contendo o tipo e os dados
     */
    public void handleSystemCall(SystemCall call) {
        System.out.println("[OS Núcleo - " + name + "] Atendendo chamada: " + call.getType());
        if (call.getType().equals(SystemCall.RECEIVE_DATA)) {
            System.out.println("[OS Núcleo - " + name + "] Processando dados recebidos: " + call.getData());
        }
    }
}
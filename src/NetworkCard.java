/**
 * Simula a placa de rede de uma Máquina Virtual.
 * Ao receber dados, gera uma SystemCall.
 */
class NetworkCard {
    private final VirtualMachine vm;

    /**
     * Associa a placa de rede a uma VM.
     * @param vm Máquina Virtual proprietária da placa
     */
    public NetworkCard(VirtualMachine vm) {
        this.vm = vm;
    }

    /**
     * Simula o recebimento de dados na placa de rede.
     * @param data Dados recebidos
     */
    public void receiveData(String data) {
        System.out.println("[NetworkCard] Dados recebidos: " + data);
        SystemCall call = new SystemCall(SystemCall.RECEIVE_DATA, data);
        vm.getOperatingSystem().handleSystemCall(call);
    }
}
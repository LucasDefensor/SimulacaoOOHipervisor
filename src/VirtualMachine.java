/**
 * Representa uma Maquina Virtual.
 * Contem um SO e uma Placa de Rede.
 */
class VirtualMachine {
    private final String name;
    private final OperatingSystem os;
    private NetworkCard networkCard;

    /**
     * Cria uma nova Maquina Virtual.
     * @param name Nome identificador da VM
     */
    public VirtualMachine(String name) {
        this.name = name;
        this.os = new OperatingSystem(name + "_OS");
    }

    public String getName() {
        return name;
    }

    public OperatingSystem getOperatingSystem() {
        return os;
    }

    public void setNetworkCard(NetworkCard networkCard) {
        this.networkCard = networkCard;
    }

    /**
     * Simula uma aplicação em modo usuário requisitando acesso à rede.
     * @param data Dados a serem recebidos
     */
    public void requestNetworkAccess(String data) {
        System.out.println("\n[VM Usuário - " + name + "] Requisitando acesso à rede...");

        // A placa de rede fisica processa os dados (recurso compartilhado)
        networkCard.receiveData(name, data);

        // Apos processamento pela placa fisica, o SO trata a chamada
        SystemCall call = new SystemCall(SystemCall.RECEIVE_DATA, data);
        os.handleSystemCall(call);
    }
}

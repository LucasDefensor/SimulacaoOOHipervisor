/**
 * Representa uma Máquina Virtual.
 * Contém um SO e uma Placa de Rede.
 */
class VirtualMachine {
    private final String name;
    private final OperatingSystem os;
    private final NetworkCard networkCard;

    /**
     * Cria uma nova Máquina Virtual.
     * @param name Nome identificador da VM
     */
    public VirtualMachine(String name) {
        this.name = name;
        this.os = new OperatingSystem(name + "_OS");
        this.networkCard = new NetworkCard(this);
    }

    public String getName() {
        return name;
    }

    public OperatingSystem getOperatingSystem() {
        return os;
    }

    public NetworkCard getNetworkCard() {
        return networkCard;
    }

    /**
     * Simula uma aplicação em modo usuário requisitando acesso à rede.
     * @param data Dados a serem recebidos
     */
    public void requestNetworkAccess(String data) {
        System.out.println("[VM Usuário - " + name + "] Requisitando acesso à rede...");
        networkCard.receiveData(data);
    }
}
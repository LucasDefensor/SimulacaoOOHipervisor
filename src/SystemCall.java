/**
 * Representa uma chamada de sistema (System Call)
 * gerada pelo modo usuário e tratada pelo modo núcleo do SO.
 */
class SystemCall {
    public static final String RECEIVE_DATA = "RECEIVE_DATA";

    private final String type;
    private final String data;

    /**
     * Cria uma chamada de sistema.
     * @param type Tipo da chamada (ex.: RECEIVE_DATA)
     * @param data Dados associados a chamada
     */
    public SystemCall(String type, String data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}
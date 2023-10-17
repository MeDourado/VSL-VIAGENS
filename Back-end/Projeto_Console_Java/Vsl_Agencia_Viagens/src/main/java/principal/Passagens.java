package principal;

public class Passagens {
    private int passagemID;
    private Cliente cliente;
    private String local_partida;
    private Destino destino;
    private Voos voos;
    private int valor;

    public Passagens(Cliente cliente, String local_partida, Destino destino, Voos voos, int valor) {
        this.cliente = cliente;
        this.local_partida = local_partida;
        this.destino = destino;
        this.voos = voos;
        this.valor = valor;
    }

    public Passagens() {

    }


    public Voos getVoos() {
        return voos;
    }

    public void setVoos(Voos voos) {
        this.voos = voos;
    }

    public int getPassagemID() {
        return passagemID;
    }

    public void setPassagemID(int passagemID) {
        this.passagemID = passagemID;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getLocal_partida() {
        return local_partida;
    }

    public void setLocal_partida(String local_partida) {
        this.local_partida = local_partida;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }


    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}

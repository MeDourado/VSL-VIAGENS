package principal;

public class Destino {
    private int destinoID;
    private String nomeDestino;

    public Destino(int destinoID, String nomeDestino) {
        this.destinoID = destinoID;
        this.nomeDestino = nomeDestino;
    }
    public Destino() {

    }
    public int getDestinoID() {
        return destinoID;
    }

    public void setDestinoID(int destinoID) {
        this.destinoID = destinoID;
    }

    public String getNomeDestino() {
        return nomeDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }






}

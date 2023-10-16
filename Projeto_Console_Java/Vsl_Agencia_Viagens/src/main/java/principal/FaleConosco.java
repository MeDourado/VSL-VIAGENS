package principal;

public class FaleConosco {
    private int contatoID;
    private Cliente cliente;


    private Passagens passagens;
    private String mensagem;

    public FaleConosco(Cliente cliente, Passagens passagens, String mensagem) {
        super();
        this.cliente = cliente;
        this.passagens = passagens;
        this.mensagem = mensagem;
    }

    public FaleConosco() {

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Passagens getPassagens() {
        return passagens;
    }

    public void setPassagens(Passagens passagens) {
        this.passagens = passagens;
    }


    public int getContatoID() {
        return contatoID;
    }

    public void setContatoID(int contatoID) {
        this.contatoID = contatoID;
    }
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }




}

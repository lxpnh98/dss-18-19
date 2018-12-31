package configurafacil;

public class Encomenda extends java.util.Observable {
    private int idComponente;
    private int quantidade;

    public Encomenda() {
    	this.idComponente = 0;
    	this.quantidade = 0;
    }

    public Encomenda(int idComponente, int quantidade) {
        this.idComponente = idComponente;
        this.quantidade = quantidade;
    }

    public Encomenda(Encomenda encomenda) {
        this.idComponente = encomenda.getIdComponente();
        this.quantidade = encomenda.getQuantidade();
    }

    public int getIdComponente() {
        return this.idComponente;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setIdComponente(int idComponente) {
    	this.idComponente = idComponente;
    }

    public void setQuantidade(int quantidade) {
    	this.quantidade = quantidade;
    }
}
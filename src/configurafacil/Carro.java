package configurafacil;

import java.time.LocalDateTime;

public class Carro extends java.util.Observable {

    private int id;
    private int idCliente;
    private int idConfig;
    private float preco;
    private boolean	pronto;
    private LocalDateTime dataEncomenda;

    public Carro() {
        this.id = 0;
        this.idCliente = 0;
        this.idConfig = 0;
        this.preco = 0.0f;
        this.pronto = false;
        this.dataEncomenda = LocalDateTime.now(); 
    }

    public Carro(int id, int cliente, int config, float preco, boolean pronto, LocalDateTime dataEncomenda) {
        this.id = id;
        this.idCliente = cliente;
        this.idConfig = config;
        this.preco = preco;
        this.pronto = pronto;
        this.dataEncomenda = dataEncomenda;
    }

    public Carro(Carro carro) {
        this.id = carro.getId();
        this.idCliente = carro.getIdCliente();
        this.idConfig = carro.getIdConfig();
        this.preco = carro.getPreco();
        this.pronto = carro.getPronto();
        this.dataEncomenda = carro.getDataEncomenda();
    }

    public int getId() {
        return this.id;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public int getIdConfig() {
        return this.idConfig;
    }

    public float getPreco() {
        return this.preco;
    }

    public boolean getPronto() {
    	return this.pronto;
    }

    public LocalDateTime getDataEncomenda() {
        return this.dataEncomenda;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(int cliente) {
        this.idCliente = cliente;
    }

    public void setConfig(int config) {
        this.idConfig = config;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setPronto(boolean pronto) {
    	this.pronto = pronto;
    }

    public void setDataEncomenda(LocalDateTime dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    public Carro clone() {
        return new Carro(this);
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if((o == null) || (o.getClass() != this.getClass())) return false;
        Carro c = (Carro) o;
        return (this.id == c.getId()) && (this.idCliente == c.getIdCliente()) && (this.idConfig == c.getIdConfig()) &&
               (this.preco == c.getPreco()) && (this.pronto == c.getPronto()) && (this.dataEncomenda.equals(c.getDataEncomenda()));
    }

    public String toString() {
        return "Carro {id: " + this.id + ", Cliente_id: " + this.idCliente + 
               ", Configuracao_id: " + this.idConfig + ", preco: " + this.preco + 
               ", pronto: " + this.pronto + ", data encomenda: " + this.dataEncomenda + "}";
    }
}
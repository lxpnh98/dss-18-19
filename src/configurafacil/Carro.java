package configurafacil;

/**
 *
 * @author TIagoasfasf
 */
public class Carro extends java.util.Observable {
    private int id;
    private int idCliente;
    private int idConfig;
    private float preco;

    public Carro() {
        this.id = 0;
        this.idCliente = 0;
        this.idConfig = 0;
        this.preco = 0.0f;
    }

    public Carro(int id, int cliente, int config, float preco) {
        this.id = id;
        this.idCliente = cliente;
        this.idConfig = config;
        this.preco = preco;
    }

    public Carro(Carro carro) {
        this.id = carro.getId();
        this.idCliente = carro.getIdCliente();
        this.idConfig = carro.getIdConfig();
        this.preco = carro.getPreco();
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

    public Carro clone() {
        return new Carro(this);
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if((o == null) || (o.getClass() != this.getClass())) return false;
        Carro c = (Carro) o;
        return (this.id == c.getId()) && (this.idCliente == c.getIdCliente()) && (this.idConfig == c.getIdConfig());
    }

    public String toString() {
        return "Carro {id: " + this.id + ", Cliente_id: " + this.idCliente + ", Configuracao_id: " + this.idConfig + ", preco: " + this.preco + "}";
    }
    
    public Configuracao getConfiguracao(){
        Configuracao config = new Configuracao();
        int id = this.getIdConfig();
        
        // TODO Implementar método
        
        return config;
    }
}

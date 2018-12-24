package configurafacil;

/**
 *
 * @author TIagoasfasf
 */
public class Carro extends java.util.Observable {
    private int id;
    private int idCliente;
    private int idConfig;

    public Carro() {
        this.id = 0;
        this.idCliente = 0;
        this.idConfig = 0;
    }

    public Carro(int id, int cliente, int config) {
        this.id = id;
        this.idCliente = cliente;
        this.idConfig = config;
    }

    public Carro(Carro carro) {
        this.id = carro.getId();
        this.idCliente = carro.getIdCliente();
        this.idConfig = carro.getIdConfig();
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

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(int cliente) {
        this.idCliente = cliente;
    }

    public void setConfig(int config) {
        this.idConfig = config;
    }

    public Carro clone() {
        return this;
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if((o == null) || (o.getClass() != this.getClass())) return false;
        Carro c = (Carro) o;
        return (this.id == c.getId()) && (this.idCliente == c.getIdCliente()) && (this.idConfig == c.getIdConfig());
    }

    public String toString() {
        return "Carro {id: " + this.id + ", Cliente_id: " + this.idCliente + ", Configuracao_id: " + this.idConfig + "}";
    }
    
    public Configuracao getConfiguracao(){
        Configuracao config = new Configuracao();
        int id = this.getIdConfig();
        
        // TODO Implementar método
        
        return config;
    }
}

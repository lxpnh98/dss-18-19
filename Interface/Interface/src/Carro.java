/**
 *
 * @author TIagoasfasf
 */
public class Carro {
    private int id;
    private Cliente cliente;

    public Carro(){
        this.id = 0;
        this.cliente = new Cliente();
    }

    public Carro(int id, Cliente c) {
        this.id = id;
        this.cliente = c;
    }

    public Carro(Carro carro) {
        this.id = carro.getId();
        this.cliente = carro.getCliente();
    }

    public int getId() {
        return this.id;
    }

    public Cliente getCliente() {
        return this.cliente.clone();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente c) {
        this.cliente = c;
    }

    public Carro clone() {
        return this;
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if((o == null) || (o.getClass() != this.getClass())) return false;
        Carro c = (Carro) o;
        return (this.cliente.equals(c.getCliente()));
    }

    public String toString() {
        return "Cliente id: " + this.cliente.getId();
    }
}
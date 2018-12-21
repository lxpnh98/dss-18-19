/**
 *
 * @author TIagoasfasf
 */
public class Pacote {

    private int id;
    private String nome;
    private float preco;

    public Pacote () {
        this.id = 0;
        this.nome = "";
        this.preco = 0;
    }

    public Pacote(int id, String nome, float preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Pacote(Pacote p) {
        this.id = p.getId();
        this.nome = p.getNome();
        this.preco = p.getPreco();
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Pacote clone() {
        return this;
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if((o == null) || (o.getClass() != this.getClass())) return false;
        Pacote p = (Pacote) o;
        return (this.id == p.getId()) && (this.nome.equals(p.getNome())) &&
               (this.preco == p.getPreco());
    }

    public String toString() {
        return "Nome: " + this.nome + "\nId:" + this.id + "\nPreco: " + this.preco;
    }
}

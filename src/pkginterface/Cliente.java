package pkginterface;

/**
 *
 * @author TIagoasfasf
 */
public class Cliente {
    private int id;
    private String nome;
    private long tlmv;
    private String email;
    private long nif;

    public Cliente() {
        this.id = 0;
        this.nome = "";
        this.tlmv = 0;
        this.email = "";
        this.nif = 0;
    }

    public Cliente(int id, String nome, long tlmv, String email, long nif) {
        this.id = id;
        this.nome = nome;
        this.tlmv = tlmv;
        this.email = email;
        this.nif = nif;
    }

    public Cliente(Cliente c) {
        this.id = c.getId();
        this.nome = c.getNome();
        this.tlmv = c.getTlmv();
        this.email = c.getEmail();
        this.nif = c.getNif();
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }
    
    public long getTlmv() {
        return this.tlmv;
    }

    public String getEmail() {
        return this.email;
    }
    
    public long getNif() {
        return this.nif;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTlmv(long tlmv) {
        this.tlmv = tlmv;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNif(long nif) {
        this.nif = nif;
    }

    public Cliente clone() {
        return this;
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if((o == null) || (o.getClass() != this.getClass())) return false;
        Cliente c = (Cliente) o;
        return (this.id == c.getId()) && (this.nome.equals(c.getNome())) &&
               (this.tlmv == c.getTlmv()) && (this.email.equals(c.getEmail())) &&
               (this.nif == c.getNif());
    }

    public String toString() {
        return "Nome: " + this.nome + "\nId:" + this.id + "\nTlmv: " + this.tlmv +
               "\nEmail: " + this.email + "\nNif: " + this.nif;
    }
}
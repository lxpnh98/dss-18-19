package configurafacil;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author TIagoasfasf
 */
public class Componente extends java.util.Observable {

    private int id;
    private String nome;
    private float preco;
    private Set<Integer> necessarios;
    private Set<Integer> incompativeis;

    public Componente () {
        this.id = 0;
        this.nome = "";
        this.preco = 0;
    }

    public Componente(int id, String nome, float preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Componente(Componente c) {
        this.id = c.getId();
        this.nome = c.getNome();
        this.preco = c.getPreco();
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
    
    public Set<Integer> getComponentesNecessarios() {
        HashSet<Integer> r;
        r = new HashSet<>();
        for(int i : this.necessarios) {
            r.add(i);
        }
        return r;
    }
    
    public Set<Integer> getComponentesIncompativeis() {
        HashSet<Integer> r;
        r = new HashSet<>();
        for(int i : this.incompativeis) {
            r.add(i);
        }
        return r;
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
    
    public void setComponentesNecessarios(int idComponente) {
        this.necessarios.add(idComponente);
    }
    
    public void setComponentesIncompativeis(int idComponente) {
        this.incompativeis.add(idComponente);
    }

    public Componente clone() {
        return this;
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if((o == null) || (o.getClass() != this.getClass())) return false;
        Componente c = (Componente) o;
        return (this.id == c.getId()) && (this.nome.equals(c.getNome())) && (this.preco == c.getPreco());
    }

    public String toString() {
        return "Nome: " + this.nome + "\nId:" + this.id + "\nPreco: " + this.preco;
    }
}
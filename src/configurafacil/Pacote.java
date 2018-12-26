package configurafacil;

import java.util.*;

public class Pacote extends java.util.Observable {

    private int id;
    private String nome;
    private float preco;
    private Set<Integer> componentes;

    public Pacote () {
        this.id = 0;
        this.nome = "";
        this.preco = 0;
        this.componentes = new HashSet<>();
    }

    public Pacote(int id, String nome, float preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.componentes = new HashSet<>();
    }

    public Pacote(Pacote p) {
        this.id = p.getId();
        this.nome = p.getNome();
        this.preco = p.getPreco();
        this.componentes = p.getComponentes();
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

    public Set<Integer> getComponentes() {
        HashSet<Integer> r;
        r = new HashSet<>();
        for(int i : this.componentes) {
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

    public void setComponentes(Set<Integer> s) {
        this.componentes = new HashSet<>();
        for(int i : s) {
            this.componentes.add(i);
        }
    }

    public void addComponente(int i) {
        this.componentes.add(i);
    }

    public Pacote clone() {
        return new Pacote(this);
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if((o == null) || (o.getClass() != this.getClass())) return false;
        Pacote p = (Pacote) o;
        return (this.id == p.getId()) && (this.nome.equals(p.getNome())) &&
               (this.preco == p.getPreco()) && (this.componentes.equals(p.getComponentes()));
    }

    public String toString() {
        return "Nome: " + this.nome + "\nId:" + this.id + "\nPreco: " + this.preco + "\nComponentes: " + this.componentes;
    }
}

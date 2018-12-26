package configurafacil;

import java.util.*;

public class Componente extends java.util.Observable {

    private int id;
    private String nome;
    private float preco;
    private int stock;
    private Set<Integer> dependencias;
    private Set<Integer> incompativeis;

    public Componente () {
        this.id = 0;
        this.nome = "";
        this.preco = 0;
        this.stock = 0;
        this.dependencias = new HashSet<>();
        this.incompativeis = new HashSet<>();
    }

    public Componente(int id, String nome, float preco, int stock) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.stock = stock;
        this.dependencias = new HashSet<>();
        this.incompativeis = new HashSet<>();
    }

    public Componente(Componente c) {
        this.id = c.getId();
        this.nome = c.getNome();
        this.preco = c.getPreco();
        this.stock = c.getStock();
        this.dependencias = c.getDependencias();
        this.incompativeis = c.getIncompativeis();
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

    public int getStock() {
        return this.stock;
    }
    
    public Set<Integer> getDependencias() {
        HashSet<Integer> r;
        r = new HashSet<>();
        for(int i : this.dependencias) {
            r.add(i);
        }
        return r;
    }
    
    public Set<Integer> getIncompativeis() {
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
    
    public void setStock(int stock) {
        this.stock = stock;
    }

    public void addDependencia(int idComponente) {
        this.dependencias.add(idComponente);
    }
    
    public void addIncompativel(int idComponente) {
        this.incompativeis.add(idComponente);
    }

    public void setDependencias(Set<Integer> s) {
        this.dependencias = new HashSet<>();
        for(int i : s) {
            this.dependencias.add(i);
        }
    }
    
    public void setIncompativeis(Set<Integer> s) {
        this.incompativeis = new HashSet<>();
        for(int i : s) {
            this.incompativeis.add(i);
        }
    }

    public Componente clone() {
        return new Componente(this);
    }

    public String toString() {
        return "Nome: " + this.nome + "\nId:" + this.id + "\nPreco: " + this.preco +
               "\nStock: " + this.stock;
    }
}

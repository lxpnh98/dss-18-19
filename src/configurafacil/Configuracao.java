package configurafacil;

import java.util.Set;
import java.util.HashSet;

class SemConfigBasicaException extends Exception {
    public SemConfigBasicaException(int num) {
        super("" + num);
    }
}

/**
 *
 * @author TIagoasfasf
 */
public class Configuracao extends java.util.Observable {

    private int id;
    private Set<Integer> pacotes;
    private Set<Integer> componentes;

    public Configuracao () {
        this.id = 0;
        this.pacotes = new HashSet<>();
        this.componentes = new HashSet<>();
    }

    public Configuracao(int id) {
        this.id = id;
        this.pacotes = new HashSet<>();
        this.componentes = new HashSet<>();
    }

    public Configuracao(Configuracao c) {
        this.id = c.getId();
        this.pacotes = c.getPacotes();
        this.componentes = c.getComponentes();
    }

    public int getId() {
        return this.id;
    }

    public Set<Integer> getPacotes() {
        HashSet<Integer> r;
        r = new HashSet<>();
        for(int i : this.pacotes) {
            r.add(i);
        }
        return r;
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

    public void setPacotes(int idPacote) {
        this.pacotes.add(idPacote);
    }

    public void setComponentes(int idComponente) {
        this.componentes.add(idComponente);
    }

    public Configuracao clone() {
        return this;
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if((o == null) || (o.getClass() != this.getClass())) return false;
        Configuracao c = (Configuracao) o;
        return (this.id == c.getId()) && (this.pacotes.equals(c.getPacotes())) && (this.componentes.equals(c.getComponentes()));
    }

    public String toString() {
        return "Id da configuracao: " + this.id + "\nPacotes: " + this.pacotes + "\nComponentes: " + this.componentes;
    }
    
    public void addConfBasica(){
        // TODO implementar método
        setChanged();
        notifyObservers();
    }
    
    public void setConfiguracao(Configuracao config){
        // TODO implementar método
        setChanged();
        notifyObservers();
    }
}
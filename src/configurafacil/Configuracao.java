package configurafacil;

import java.util.*;

public class Configuracao extends java.util.Observable {

    private int id;
    private String motor;
    private String pintura;
    private String jantes;
    private String pneus;
    private String detalhesInteriores;
    private String detalhesExteriores;
    private Set<Integer> pacotes;
    private Set<Integer> componentes;

    public Configuracao () {
        this.id = 0;
        this.motor = "";
        this.pintura = "";
        this.jantes = "";
        this.pneus = "";
        this.detalhesInteriores = "";
        this.detalhesExteriores = "";
        this.pacotes = new HashSet<>();
        this.componentes = new HashSet<>();
    }

    public Configuracao(int id, String motor, String pintura, String jantes, String pneus, String detInteriores, String detExteriores) {
        this.id = id;
        this.motor = motor;
        this.pintura = pintura;
        this.jantes = jantes;
        this.pneus = pneus;
        this.detalhesInteriores = detInteriores;
        this.detalhesExteriores = detExteriores;
        this.pacotes = new HashSet<>();
        this.componentes = new HashSet<>();
    }

    public Configuracao(Configuracao c) {
        this.id = c.getId();
        this.motor = c.getMotor();
        this.pintura = c.getPintura();
        this.jantes = c.getJantes();
        this.pneus = c.getPneus();
        this.detalhesInteriores = c.getDetInteriores();
        this.detalhesExteriores = c.getDetExteriores();
        this.pacotes = c.getPacotes();
        this.componentes = c.getComponentes();
    }

    public int getId() {
        return this.id;
    }
    
    public String getMotor() {
        return this.motor;
    }

    public String getPintura() {
        return this.pintura;
    }

    public String getJantes() {
        return this.jantes;
    }

    public String getPneus() {
        return this.pneus;
    }

    public String getDetInteriores() {
        return this.detalhesInteriores;
    }

    public String getDetExteriores() {
        return this.detalhesExteriores;
    }

    public void setMotor(String m) {
        this.motor = m;
    }

    public void setPintura(String p) {
        this.pintura = p;
    }

    public void setJantes(String j) {
        this.jantes = j;
    }

    public void setPneus(String p) {
        this.pneus = p;
    }

    public void setDetInteriores(String di) {
        this.detalhesInteriores = di;
    }

    public void setDetExteriores(String de) {
        this.detalhesExteriores = de;
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

    public void addPacote(int idPacote) {
        this.pacotes.add(idPacote);
    }

    public void addComponente(int idComponente) {
        this.componentes.add(idComponente);
    }

    public void setPacotes(Set<Integer> s) {
        this.pacotes = new HashSet<>();
        for(int i : s) {
            this.pacotes.add(i);
        }
    }

    public void setComponentes(Set<Integer> s) {
        this.componentes = new HashSet<>();
        for(int i : s) {
            this.componentes.add(i);
        }
    }

    public Configuracao clone() {
        return new Configuracao(this);
    }

    public String toString() {
        return "Id da configuracao: " + this.id + "\nPacotes: " + this.pacotes + "\nComponentes: " + this.componentes;
    }
}

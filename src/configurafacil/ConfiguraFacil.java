package configurafacil;

import java.util.stream.Collectors;
import java.util.*;
import java.time.LocalDateTime;
import pkgdados.DadosFacade;

public class ConfiguraFacil extends java.util.Observable {
    private DadosFacade dados;

    public ConfiguraFacil(DadosFacade dados) {
        this.dados = dados;
    }

    public void createConfiguracao(){
        this.dados.createConfiguracao();
    }

    public Configuracao getConfiguracao(int id){
        return this.dados.getConfiguracao(id);
    }

    public Configuracao getConfiguracaoAtual(){
        return this.dados.getConfiguracaoAtual();
    }

    public Componente getComponente(int id){
        return this.dados.getComponente(id);
    }

    public void setConfigAtual(Configuracao config){
        this.dados.setConfiguracaoAtual(config);
    }

    public Cliente getCliente(int id){
        return this.dados.getCliente(id);
    }

    public void setCliente(Cliente cliente){
        this.dados.setCliente(cliente);
    }

    public Set<Integer> listaDependencias(int id) {
        Set<Integer> lista = new HashSet<Integer>();
        Set<Integer> deps = new HashSet<Integer>();

        Componente componente = this.dados.getComponente(id);
        deps = componente.getDependencias();

        for(Integer dep : deps) {
            if(!lista.contains(dep)) {
                lista.add(dep);
                Set<Integer> depDeps = listaDependencias(dep);
                lista.addAll(depDeps);
            } 
        }

        return lista;
    }

    public boolean verificaIncompatibilidades(int id, Set<Integer> componentes) {
        Set<Integer> listaIncompativeis = new HashSet<Integer>();

        Configuracao config = this.dados.getConfiguracaoAtual();
        Set<Integer> idComponentes = config.getComponentes();

        for(Integer i : idComponentes) {
            Componente cConfig = this.dados.getComponente(i);
            Set<Integer> cConfigIncompatibilidades = cConfig.getIncompativeis();
            listaIncompativeis.addAll(cConfigIncompatibilidades);
        }

        if(listaIncompativeis.contains(id)) {
            return false;
        } else if(!Collections.disjoint(listaIncompativeis,componentes)) {
            return false;
        }

        return true;
    }

    public void adicionaComponentes(Set<Integer> ids) {
        for(Integer i : ids) {
            adicionaComponente(i);
        }
    }

    public void adicionaComponente(int id) {
        Set<Integer> listaDep = listaDependencias(id);
        if(verificaIncompatibilidades(id,listaDep)) {
            Configuracao config = this.dados.getConfiguracaoAtual();
            config.addComponente(id);

            Set<Integer> idPacotes = this.dados.listaPacotes();
            Set<Integer> comps = config.getComponentes();

            for(Integer idPacote : idPacotes) {
                Pacote p = this.dados.getPacote(idPacote);
                Set<Integer> pacoteComps = p.getComponentes();

                if(comps.containsAll(pacoteComps)) {
                    addPacote(idPacote);
                    break;
                }
            }

            this.dados.setConfiguracaoAtual(config);
        } else {
            System.out.println("Componente incompativel: " + id);
        }
    }

    public void addPacote(int idPacote) {
        Configuracao config = this.dados.getConfiguracaoAtual();
        config.addPacote(idPacote);

        Pacote p = this.dados.getPacote(idPacote);
        Set<Integer> pacoteComps = p.getComponentes();
        Set<Integer> comps = config.getComponentes();

        for(Integer r : pacoteComps) {
            comps.remove(r);
        }
        config.setComponentes(comps);
        this.dados.setConfiguracaoAtual(config);
    }

    public boolean identificaCliente(String nome, String tlmv, String email, String nif) {
        if (Cliente.validaInfo(nome,tlmv,email,nif)) {
            Cliente c = new Cliente(0,nome,tlmv,email,nif);
            this.dados.setCliente(c);
            System.out.println("Identificação realizada com sucesso");
            return true;
        } else {
            System.out.println("Identificação sem sucesso");
            return false;
        }
    }

    public void adicionaCarro() {
        Configuracao config = this.dados.getConfiguracaoAtual();
        Cliente cliente = this.dados.getClienteAtual();
        QueueProducao q = this.dados.getQueueProducao();

        Set<Integer> componentes = config.getComponentes();
        Set<Integer> pacotes = config.getPacotes();

        int idConfig = config.getId();
        int idCliente = cliente.getId();
        boolean pronto = estaPronto(componentes,pacotes);
        float preco = getPreco(componentes,pacotes);

        Carro carro = new Carro(0,idConfig,idCliente,preco,LocalDateTime.now(),pronto);

        q.queue.add(carro);
        this.dados.setQueueProducao(q);

        if(pronto == true) {
            atualizaComponente(componentes,pacotes); 
        }
    }

    //Auxiliar da adicionaCarro()
    public boolean estaPronto(Set<Integer> componentes,Set<Integer> pacotes) {
        for(Integer i : pacotes) {
            Pacote p = this.dados.getPacote(i);
            Set<Integer> c = p.getComponentes();
            for(Integer j : c) {
                componentes.add(j);
            }
        }

        for(Integer k : componentes) {
            Componente c = this.dados.getComponente(k);
            if(c.getStock() == 0) {
                return false;
            }
        }
        return true;
    }

    //Auxiliar da adicionaCarro()
    public float getPreco(Set<Integer> componentes,Set<Integer> pacotes) {
        float preco = 0;

        for(Integer i : pacotes) {
            Pacote p = this.dados.getPacote(i);
            preco += p.getPreco();
        }
        
        for(Integer j : componentes) {
            Componente c = this.dados.getComponente(j);
            preco += c.getPreco();
        }
        return preco;
    }

    //Auxiliar da adicionaCarro()
    public void atualizaComponente(Set<Integer> componentes,Set<Integer> pacotes) {
        for(Integer i : pacotes) {
            Pacote p = this.dados.getPacote(i);
            Set<Integer> c = p.getComponentes();
            for(Integer j : c) {
                componentes.add(j);
            }
        }
        
        for(Integer k : componentes) {
            Componente c = this.dados.getComponente(k);
            int quantidade = c.getStock()-1;
            c.setStock(quantidade);
            this.dados.setComponente(c);
        }
    }

    public void atualizaQueue() {
        QueueProducao q = this.dados.getQueueProducao();
        if(q.queue.size()>0) {
            q.queue.remove();
            this.dados.setQueueProducao(q);
        }
    }

    public void configuracaoBasica(String motor, String pintura, String pneus, String jantes,
                                   String detInteriores,  String detExteriores) {
        Configuracao config = this.dados.getConfiguracaoAtual();
        config.setMotor(motor);
        config.setPintura(pintura);
        config.setPneus(pneus);
        config.setJantes(jantes);
        config.setDetInteriores(detInteriores);
        config.setDetExteriores(detExteriores);
        this.dados.setConfiguracaoAtual(config);
    }

    public Configuracao calculaConfiguracaoOtima(float orcamento) {
        Configuracao config = this.dados.getConfiguracaoAtual();
        Set<Integer> listaPacotes = this.dados.listaPacotes();

        List<Pacote> pacotes = listaPacotes.stream()
                                        .map(i -> (Pacote)this.dados.getPacote(i))
                                        .collect(Collectors.toList());
        Collections.sort(pacotes, (p1, p2) -> (new Float (p1.getPreco())).compareTo(p2.getPreco()));
        
        float orcamentoDisp = orcamento;

        for(Pacote p : pacotes) {
            if(p.getPreco() > orcamentoDisp) {
                return null; // calculaComponentes(orcamento); 
            } else {
                config.addPacote(p.getId());
                this.dados.setConfiguracaoAtual(config);
                orcamentoDisp = orcamentoDisp - p.getPreco();
            }
        }
        return config;
    }

    public CarroInfo verCarro(int id) {
        QueueProducao q = this.dados.getQueueProducao();
        Carro car = q.getCarro(id);

        int idCliente = car.getIdCliente();
        int idConfig = car.getIdConfig();
        float preco = car.getPreco();

        Cliente cliente = this.dados.getCliente(idCliente);
        Configuracao config = this.dados.getConfiguracao(idConfig);
        CarroInfo carro = new CarroInfo(cliente,config,preco);
        return carro;
    }

    public QueueProducao verQueueProducao() {
        QueueProducao q = this.dados.getQueueProducao();
        return q;
    }
}

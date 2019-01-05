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
    
    public Pacote getPacote(int id){
        return this.dados.getPacote(id);
    }

    public Set<Integer> listaComponetes(){
        return this.dados.listaComponentes();
    }

    public Set<Integer> listaIncompativeis(int id) {
        Set<Integer> lista = new HashSet<Integer>();
        Set<Integer> deps = new HashSet<Integer>();

        Componente componente = this.dados.getComponente(id);
        deps = componente.getDependencias();

        for (Integer inc : componente.getIncompativeis()){
            if(!lista.contains(inc)) {
                lista.add(inc);
            }
        }
        
        for(Integer dep : deps) {
            Set<Integer> depDeps = listaIncompativeis(dep);
            for (Integer de : depDeps){
                if(!lista.contains(de)) {
                    lista.add(de);
                }
            }
        }
        return lista;
    }
    
    public Set<Integer> listaDependencias(int id) {
        Set<Integer> lista = new HashSet<Integer>();
        Set<Integer> deps;

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

    public boolean verificaIncompatibilidades(int id, Set<Integer> componentes, Set<Integer> idComponentesConfig, Set<Integer> componentesPacotes) {
        Set<Integer> listaIncompativeis = new HashSet<Integer>();

        for(Integer j : idComponentesConfig) {
            if(j==id) {
                return true;
            }
            Componente componenteConfig = this.getComponente(j);
            Set<Integer> componentesIncompativeis = componenteConfig.getIncompativeis();
            listaIncompativeis.addAll(componentesIncompativeis);
        }

        for(Integer k : componentesPacotes) {
            if(k==id) {
                return true;
            }
            Componente c = this.getComponente(k);
            Set<Integer> cIncompativeis = c.getIncompativeis();
            listaIncompativeis.addAll(cIncompativeis);
        }

        if(listaIncompativeis.contains(id)) {
            return true;
        } else if(!Collections.disjoint(listaIncompativeis,componentes)) {
            return true;
        }
        return false;
    }

    public void adicionaComponentes(Set<Integer> ids) {
        for(Integer i : ids) {
            adicionaComponente(i);
        }
    }

    public void adicionaComponente(int id) {
        Set<Integer> listaDep = listaDependencias(id);

        Configuracao config = this.dados.getConfiguracaoAtual();
        Set<Integer> idComponentesConfig = config.getComponentes();
        Set<Integer> idPacotesConfig = config.getPacotes();

        Set<Integer> componentesPacotes = new HashSet<>();        
        for(Integer idPac : idPacotesConfig) {
            Pacote pacote = this.dados.getPacote(idPac);
            componentesPacotes.addAll(pacote.getComponentes());
        }

        if(!verificaIncompatibilidades(id,listaDep,idComponentesConfig,componentesPacotes)) {
                config.addComponente(id);

                this.dados.setConfiguracaoAtual(config);
                config = this.dados.getConfiguracaoAtual();
                idComponentesConfig = config.getComponentes();

                Set<Integer> idPacotes = this.dados.listaPacotes();

                for(Integer idPacote : idPacotes) {
                    if(!idPacotesConfig.contains(idPacote)) {
                        Pacote p = this.dados.getPacote(idPacote);
                        Set<Integer> pacoteComps = p.getComponentes();

                        if(idComponentesConfig.containsAll(pacoteComps)) {
                            addPacote(idPacote);
                            break;
                        }
                    }
                }
                this.dados.setConfiguracaoAtual(config);        
        } else {
            System.out.println("Componente incompativel");
        }
    }

    public void addPacote(int idPacote) {
        Configuracao config = this.dados.getConfiguracaoAtual();
        Pacote p = this.dados.getPacote(idPacote);
        Set<Integer> pacoteComponentes = p.getComponentes();

        Set<Integer> pacotesConfig = config.getPacotes();
        Set<Integer> componentesInd = config.getComponentes();
        Set<Integer> componentesConfig = new HashSet<>(componentesInd);

        for(Integer idPacoteConfig : pacotesConfig) {
            Pacote pConfig = this.dados.getPacote(idPacoteConfig);
            Set<Integer> pComp = pConfig.getComponentes();
            componentesConfig.addAll(pComp);
        }

        if(!compsIncom(pacoteComponentes,componentesConfig)) {
            config.addPacote(idPacote);
            for(Integer r : pacoteComponentes) {
                componentesInd.remove(r);
            }
            config.setComponentes(componentesInd);
            this.dados.setConfiguracaoAtual(config);
        }
    }

    public boolean compsIncom(Set<Integer> componentesPacote, Set<Integer> componentesExistentes) {
        Set<Integer> incompataveis = new HashSet<>();

        for(Integer id : componentesPacote) {
            Componente c = this.dados.getComponente(id);
            incompataveis.addAll(c.getIncompativeis());
        }

        for(Integer idComp : componentesExistentes) {
            if(incompataveis.contains(idComp)) {
                return true;
            }
        }
        return false;
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

    public void carroProduzido() {
        QueueProducao q = this.dados.getQueueProducao();
        q.remove();
        this.dados.setQueueProducao(q);
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

        Collections.sort(pacotes, (p1, p2) -> (new Float (p2.getPreco())).compareTo(p1.getPreco()));

        float orcamentoDisp = orcamento;
        for(Pacote p : pacotes) {
            int idPacote = p.getId();
            if(p.getPreco() <= orcamentoDisp) {
                boolean comp = true;
                Set<Integer> componentes = config.getComponentes();

                if (componentesIncompativeis(idPacote, componentes)){
                    comp = false;
                    break;
                }

                if(comp) {
                    for (Integer id : config.getPacotes()) {
                        if (pacotesIncompativeis(idPacote, id)){
                            comp = false;
                            break;
                        }
                    }

                    if (comp){
                        config.addPacote(idPacote);
                        orcamentoDisp = orcamentoDisp - p.getPreco();
                    }
                }
            }
        }
        return config;
    }

    public boolean componentesIncompativeis(int idPacote1 , Set<Integer> componentesExistentes) {
        Pacote p1 = this.dados.getPacote(idPacote1);
        Set<Integer> componentes = p1.getComponentes();
        Set<Integer> incompataveis = new HashSet<>();

        for(Integer id : componentes) {
            Componente c = this.dados.getComponente(id);
            incompataveis.addAll(c.getIncompativeis());
        }

        for(Integer idComp : componentesExistentes) {
            if(incompataveis.contains(idComp)) {
                return true;
            }
        }
        return false;
    }

    public boolean pacotesIncompativeis(int idPacote1, int idPacote2) {
        Pacote p1 = this.dados.getPacote(idPacote1);
        Pacote p2 = this.dados.getPacote(idPacote2);

        Set<Integer> componentes1 = p1.getComponentes();
        Set<Integer> componentes2 = p2.getComponentes();

        Set<Integer> incompataveis = new HashSet<>();
        for(Integer id : componentes1) {
            Componente c = this.dados.getComponente(id);
            incompataveis.addAll(c.getIncompativeis());
        }

        for(Integer idComp2 : componentes2) {
            if(incompataveis.contains(idComp2)) {
                return true;
            }
        }
        return false;
    }

    public CarroInfo verCarro(int id) {
        QueueProducao q = this.dados.getQueueProducao();
        Carro car = q.getCarro(id);

        if (car == null) return null;

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

    public void atualizaStock(Set<Encomenda> encomendas) {
        int idComponente;
        int quantidade;
        for(Encomenda encomenda : encomendas) {
            idComponente = encomenda.getIdComponente();
            quantidade = encomenda.getQuantidade();
            Componente c = this.dados.getComponente(idComponente);
            c.addStock(quantidade);
            this.dados.setComponente(c);
        }
    }

    public void atualizarQueue() {
        QueueProducao q = this.dados.getQueueProducao();

        for(Carro carro : q.queue) {
            if (carro.getPronto() == false) {
                int idConfig = carro.getIdConfig();
                Configuracao config = this.dados.getConfiguracao(idConfig);
                Set<Integer> comp = config.getComponentes();
                Set<Integer> idPacotes = config.getPacotes();

                for(Integer idPacote : idPacotes) {
                    Pacote p = this.dados.getPacote(idPacote);
                    Set<Integer> comps = p.getComponentes();
                    comp.addAll(comps);
                }

                boolean pronto = podeProduzir(comp);  
                carro.setPronto(pronto);
                if(pronto==true) {
                    atualizaComponentes(comp);
                }
            }
        }

        this.dados.setQueueProducao(q);
    }

    public boolean podeProduzir(Set<Integer> comp) {
        for(Integer idComponente : comp) {
            Componente c = this.dados.getComponente(idComponente);
            if(c.getStock()<1) {
                return false;
            }
        }
        return true;
    }

    public void atualizaComponentes(Set<Integer> comp) {
        for(Integer idComponente : comp) {
            Componente c = this.dados.getComponente(idComponente);
            c.setStock(c.getStock() - 1);
            this.dados.setComponente(c);
        }
    }
}

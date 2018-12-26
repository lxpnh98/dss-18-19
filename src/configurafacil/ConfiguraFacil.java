package configurafacil;

import java.util.*;
import pkgdados.DadosFacade;

public class ConfiguraFacil extends java.util.Observable {
    private DadosFacade dados;

    public ConfiguraFacil(DadosFacade dados) {
        this.dados = dados;
    }

    public Set<Integer> listaDependencias(int id) {
        Set<Integer> lista = new HashSet<Integer>();
        Componente componente = this.dados.getComponente(id);
        lista = componente.getComponentesNecessarios();
        return lista;
    }

    public boolean verificaIncompatibilidades(int id, Set<Integer> componentes) {
        Componente c = this.dados.getComponente(id);
        Set<Integer> incompativeis = c.getComponentesIncompativeis();

        for(Integer i : componentes) {
            if(!incompativeis.contains(i)) {
                return false;
            }
        }
        return true;
    }

    //TODO: adicionaComponentes()

    //TODO: adicionaComponente()

    public void identificaCliente(String nome, String tlmv, String email, String nif) {
        if (Cliente.validaInfo(nome,tlmv,email,nif) {
            Cliente c = new Cliente(0,nome,tlmv,email,nif);
            this.dados.setCliente(c);
            System.out.println("Identificação realizada com sucesso");
        } else {
            System.out.println("Identificação sem sucesso");
        }
    }

    //adiciona carro à queue
    //TODO: adicionaCarro()
    /*public void adicionaCarro() {
        Configuracao config = this.dados.getConfiguracaoAtual();
        Cliente cliente = this.dados.getClienteAtual();
        QueueProducao q = this.dados.getQueueProducao();

        Carro carro = new Carro(0,)

    }*/

    public void atualizaQueue() {
        QueueProducao q = this.dados.getQueueProducao();
        if(q.queue.size()>0) {
            q.queue.remove();
            this.dados.setQueueProducao(q);
        }
    }

    //TODO: configuracaoBasica()

    //TODO: calculaConfiguracaoOtima()
    
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
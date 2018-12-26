package configurafacil;

import java.util.*;

/**
 *
 * @author TIagoasfasf
 */
public class ConfiguraFacil extends java.util.Observable {
    private DadosFacade dados;

    public ConfiguraFacil(DadosFacade dados) {
        this.dados = dados;
    }

    //lista de necessarios componentes
    public Set<Integer> listaDependencias(Int id) {
        Set<Integer> lista = new HashSet<Integer>();
        return lista;
    }

    // recebe uma lista de componentes e verifica se eles são ou nao incompativeis
    //TODO: verificaIncompatibilidades()

    //TODO: adicionaComponentes()

    //TODO: adicionaComponente()

    //TODO: identificaCliente()

    //adiciona carro à queue
    //TODO: adicionaCarro()

    public void atualizaQueue() {
        QueueProducao queue = new QueueProducao();
        queue = this.dados.getQueueProducao();
        if(queue.size()>0) {
            queue.remove();
            this.dados.setQueueProducao(queue);
        } else {
            // retirar o else, isto é apenas para um futuro teste.
            System.out.println("queue vazia");
        }
    }

    //TODO: configuracaoBasica()

    //TODO: calculaConfiguracaoOtima()
    
    public Carro verCarro(Int id) {
        QueueProducao queue = new QueueProducao();
        queue = this.dados.getQueueProducao();
        Carro car = new Carro();
        car = queue.getCarro(id);
        return car;
    }

    public QueueProducao verQueueProducao() {
        QueueProducao queue = new QueueProducao();
        queue = this.dados.getQueueProducao();
        return queue;
    }
}
package configurafacil;

import java.util.*;
import pkgdados.DadosFacade;
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
        QueueProducao q = this.dados.getQueueProducao();
        if(q.queue.size()>0) {
            q.queue.remove(); //é possivel que isto esteja errado.
            this.dados.setQueueProducao(q);
        } else {
            // retirar o else, isto é apenas para um futuro teste.
            System.out.println("queue vazia");
        }
    }

    //TODO: configuracaoBasica()

    //TODO: calculaConfiguracaoOtima()
    
    public Carro verCarro(int id) {
        QueueProducao q = this.dados.getQueueProducao();
        Carro car = new Carro();
        car = q.getCarro(id);
        return car;
    }

    public QueueProducao verQueueProducao() {
        QueueProducao q = this.dados.getQueueProducao();
        return q;
    }
}
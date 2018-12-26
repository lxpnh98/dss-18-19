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
    public Set<Integer> listaDependencias(int id) {
        Set<Integer> lista = new HashSet<Integer>();
        return lista;
    }

    // recebe uma lista de componentes e verifica se eles são ou nao incompativeis
    //TODO: verificaIncompatibilidades()

    // 
    //TODO: adicionaComponentes()

    //TODO: adicionaComponente()

    //TODO: identificaCliente()

    //adiciona carro à queue
    //TODO: adicionaCarro()

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

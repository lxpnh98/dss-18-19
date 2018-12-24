package configurafacil;

import java.util.*;

public class QueueProducao {
    public LinkedList<Carro> queue;
    
    public QueueProducao() {
        this.queue = new LinkedList<>();
    }

    public void add(Carro c) {
        this.queue.add(c);
    }

    public Carro remove() {
        return this.queue.remove();
    }

    public Carro getCarro(int id) {
        for (Carro c : this.queue) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }
}

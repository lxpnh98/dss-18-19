package pkgdados;

import java.util.Set;
import java.sql.*;
import configurafacil.*;

public class DadosFacade {
    private String user;
    private String password;

    public DadosFacade(String user, String password) {
        this.user = user;
        this.password = password;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    private Connection connect() {
        try {
            return new DriverManager.getConnection("jdbc:mysql://localhost/ConfiguraFacil?" +
                                                   "user=" + this.user + "&" +
                                                   "password=" + this.password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(2);
        }
    }

	public QueueProducao getQueueProducao() {
        Connection c =  connect();
        try {
            QueueProducao r = (new QueueProducaoDAO(c)).getQueueProducao();
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.close();
        }
	}

	public void setQueueProducao(QueueProducao q) {
        Connection c =  connect();
        try {
            (new QueueProducaoDAO(c)).setQueueProducao(q);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.close();
        }
	}

	public Set<Integer> listaPacotes() {
        Connection c =  connect();
        try {
            Set<Integer> r = (new PacoteDAO(c)).keySet();
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.close();
        }
	}

	public Pacote getPacote(int id) {
        Connection c =  connect();
        try {
            Pacote r = (new PacoteDAO(c)).get(id);
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.close();
        }
	}

	public Configuracao getConfiguracaoAtual() {
        Connection c =  connect();
        try {
            Configuracao r = (new ConfiguracaoDAO(c)).getConfiguracaoAtual();
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.close();
        }
	}

	public void setConfiguracao(Configuracao config) {
        Connection c =  connect();
        try {
            (new ConfiguracaoDAO(c)).setConfiguracao(config);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.close();
        }
	}

	public Configuracao getConfiguracao(int id) {
        Connection c =  connect();
        try {
            Configuracao r = (new ConfiguracaoDAO(c)).get(id);
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.close();
        }
	}

	public Componente getComponente(int id) {
        Connection c =  connect();
        try {
            Componente r = (new ComponenteDAO(c)).get(id);
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.close();
        }
	}

	public Cliente getClienteAtual() {
        Connection c =  connect();
        try {
            Cliente r = (new ClienteDAO(c)).getClienteAtual();
            return r;            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.close();
        }
	}

	public void setCliente(Cliente c) {
        Connection c =  connect();
        try {
            (new ClienteDAO(c)).setCliente();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.close();
        }
	}

	public Cliente getCliente(int id) {
        Connection c =  connect();
        try {
            Cliente r = (new ClienteDAO(c)).get(id);
            return r;            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.close();
        }
	}
}

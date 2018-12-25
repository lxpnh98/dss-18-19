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
            return DriverManager.getConnection("jdbc:mysql://localhost/ConfiguraFacil?" +
                                               "user=" + this.user + "&" +
                                               "password=" + this.password + "&useSSL=false");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(2);
        }
        return null;
    }

	public QueueProducao getQueueProducao() {
        Connection c =  connect();
        try {
            QueueProducao r = (new QueueProducaoDAO(c)).getQueueProducao();
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
	}

	public void setQueueProducao(QueueProducao q) {
        Connection c =  connect();
        try {
            (new QueueProducaoDAO(c)).setQueueProducao(q);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
	}

	public Pacote getPacote(int id) {
        Connection c =  connect();
        try {
            Pacote r = (new PacoteDAO(c)).get(id);
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
	}

	public Configuracao getConfiguracaoAtual() {
        Connection c =  connect();
        try {
            Configuracao r = (new ConfiguracaoDAO(c)).getConfiguracaoAtual();
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
	}

	public void setConfiguracao(Configuracao config) {
        Connection c =  connect();
        try {
            (new ConfiguracaoDAO(c)).setConfiguracao(config);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
	}

	public Componente getComponente(int id) {
        Connection c =  connect();
        try {
            Componente r = (new ComponenteDAO(c)).get(id);
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
	}

	public Cliente getClienteAtual() {
        Connection c =  connect();
        try {
            Cliente r = (new ClienteDAO(c)).getClienteAtual();
            return r;            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
	}

	public void setCliente(Cliente client) {
        Connection c =  connect();
        try {
            (new ClienteDAO(c)).setCliente(client);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
	}
}

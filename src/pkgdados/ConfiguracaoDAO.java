package pkgdados;

import configurafacil.*;
import java.sql.*;

public class ConfiguracaoDAO extends DAO {

    public ConfiguracaoDAO(Connection c) {
        super(c);
    }

	public Configuracao getConfiguracaoAtual() throws SQLException {
            return new Configuracao();
	}

	public void setConfiguracao(Configuracao c) throws SQLException {
	}

	public Configuracao get(int id) throws SQLException {
            return new Configuracao();
	}

}

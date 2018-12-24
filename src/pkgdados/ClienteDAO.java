package pkgdados;

import configurafacil.*;
import java.sql.*;

public class ClienteDAO extends DAO {

    public ClienteDAO(Connection c) {
        super(c);
    }

	public Cliente getClienteAtual() throws SQLException {
            return new Cliente();
	}

	public void setCliente(Cliente c) throws SQLException {
	}

	public Cliente get(int id) throws SQLException {
            return new Cliente();
	}

}

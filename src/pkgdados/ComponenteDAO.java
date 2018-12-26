package pkgdados;

import configurafacil.*;
import java.sql.*;

public class ComponenteDAO extends DAO {

    public ComponenteDAO(Connection c) {
        super(c);
    }

	public Componente get(int id) throws SQLException {
            return new Componente();
	}

	public void get(Componente c) throws SQLException {
	}
}

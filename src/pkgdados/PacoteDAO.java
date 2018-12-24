package pkgdados;

import java.util.Set;
import configurafacil.*;
import java.sql.*;
import java.util.HashSet;

public class PacoteDAO extends DAO {
 
    public PacoteDAO(Connection c) {
        super(c);
    }

	public Set<Integer> keySet() throws SQLException {
            HashSet<Integer> r;
            r = new HashSet<>();
            return r;
	}

	public Pacote get(int id) throws SQLException {
            return new Pacote();
	}

}

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
        HashSet<Integer> r = new HashSet<>();

        Statement s = this.connection.createStatement();

        ResultSet rs = s.executeQuery("select id from ConfiguraFacil.Pacote;");

        while (rs.next()) {
            r.add(rs.getInt("id"));
        }

        rs.close();
        s.close();

        return r;
	}

    public Pacote get(int id) throws SQLException {
        Pacote r = null;

        PreparedStatement ps = this.connection.prepareStatement("select * from ConfiguraFacil.Pacote where id = ?;");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            r = new Pacote(rs.getInt("id"), rs.getString("nome"), rs.getFloat("preco"));
        }

        rs.close();
        ps.close();

        return r;
	}

}

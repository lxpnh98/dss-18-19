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

        // get id, nome, e preço do pacote
        PreparedStatement ps1 = this.connection.prepareStatement("select * from ConfiguraFacil.Pacote where id = ?;");
        ps1.setInt(1, id);
        ResultSet rs1 = ps1.executeQuery();
        if (rs1.next()) {
            r = new Pacote(rs1.getInt("id"), rs1.getString("nome"), rs1.getFloat("preco"));
        }
        rs1.close();
        ps1.close();

        if (r == null) return null;

        // get ids dos componentes do pacote
        PreparedStatement ps2 = this.connection.prepareStatement("select Componente_id as id from ConfiguraFacil.PacoteCompoenente where Pacote_id = ?;");
        ps2.setInt(1, id);
        ResultSet rs2 = ps2.executeQuery();
        while (rs2.next()) {
            r.addComponente(rs2.getInt("id"));
        }

        return r;
	}

}

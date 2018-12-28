package pkgdados;

import configurafacil.*;
import java.sql.*;

public class ClienteDAO extends DAO {

    public ClienteDAO(Connection c) {
        super(c);
    }

    public Cliente getClienteAtual() throws SQLException {
        int id;

        // get id atual
        Statement s = null;
        ResultSet rs = null;
        try {
            s = this.connection.createStatement();
            rs = s.executeQuery("select id from ConfiguraFacil.Cliente order by id desc limit 1;");
            if (rs.next()) {
                id = rs.getInt("id");
            } else {
                throw new SQLException("ConfiguraFacil.Cliente is empty.");
            }
        } finally {
            if (rs != null) rs.close();
            if (s != null) s.close();
        }

        return this.get(id);
    }

    public void setCliente(Cliente c) throws SQLException {
        PreparedStatement ps = this.connection.prepareStatement("insert into ConfiguraFacil.Cliente values (default,?,?,?,?)");
        ps.setString(1, c.getNome());
        ps.setString(2, c.getTlmv());
        ps.setString(3, c.getEmail());
        ps.setString(4, c.getNif());
        ps.executeUpdate();
        ps.close();
    }

    public Cliente get(int id) throws SQLException {
        Cliente cliente = null;

        // get nome, tel, email e nif do cliente
        PreparedStatement ps1 = this.connection.prepareStatement("select * from ConfiguraFacil.Cliente where id = ?;");
        ResultSet rs1 = null;
        ps1.setInt(1, id);
        try {
            rs1 = ps1.executeQuery();
            if (rs1.next()) {
                cliente = new Cliente(rs1.getInt("id"),
                                      rs1.getString("nome"),
                                      rs1.getString("tel"),
                                      rs1.getString("email"),
                                      rs1.getString("nif"));
            } else {
                throw new SQLException("ConfiguraFacil.Configuracao is empty.");
            }
        } finally {
            if (rs1 != null) rs1.close();
            ps1.close();
        }

        return cliente;
    }

}

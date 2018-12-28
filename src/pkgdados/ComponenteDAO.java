package pkgdados;

import configurafacil.*;
import java.sql.*;

public class ComponenteDAO extends DAO {

    public ComponenteDAO(Connection c) {
        super(c);
    }

    public Componente get(int id) throws SQLException {
        Componente r = null;

        // get id, nome, preço e stock do componente
        PreparedStatement ps1 = this.connection.prepareStatement("select * from ConfiguraFacil.Componente where id = ?;");
        ps1.setInt(1, id);
        ResultSet rs1 = ps1.executeQuery();
        if (rs1.next()) {
            r = new Componente(rs1.getInt("id"), rs1.getString("nome"), rs1.getFloat("preco"), rs1.getInt("stock"));
        }
        rs1.close();
        ps1.close();

        if (r == null) return null;

        // get ids das dependencias do componente
        PreparedStatement ps2 = this.connection.prepareStatement(
            "select Dependencia_id as id from ConfiguraFacil.Dependencia where Componente_id = ?;");
        ps2.setInt(1, id);
        ResultSet rs2 = ps2.executeQuery();
        while (rs2.next()) {
            r.addDependencia(rs2.getInt("id"));
        }
        rs2.close();
        ps2.close();

        // get ids das incompatibilidades do componente
        PreparedStatement ps3 = this.connection.prepareStatement(
            "select Incompatibilidade_id as id from ConfiguraFacil.Incompatibilidade where Componente_id = ?;");
        ps3.setInt(1, id);
        ResultSet rs3 = ps3.executeQuery();
        while (rs3.next()) {
            r.addDependencia(rs3.getInt("id"));
        }
        rs3.close();
        ps3.close();

        return r;
	}

    public void set(Componente c) throws SQLException {
        int id = c.getId();
        // set nome, preco e stock do componente
        PreparedStatement ps1 = this.connection.prepareStatement(
            "update ConfiguraFacil.Componente set nome=?, preco=?, stock=? where id=?");
        ps1.setString(1, c.getNome()); 
        ps1.setFloat(2, c.getPreco()); 
        ps1.setInt(3, c.getStock()); 
        ps1.setInt(4, id); 

        // detele antigas dependencias
        PreparedStatement ps2 = this.connection.prepareStatement(
            "delete ConfiguraFacil.Dependencia where Componente_id=?;");
        ps2.setInt(1, id);
        ps2.executeUpdate();
        ps2.close();

        // insert novas dependencias
        PreparedStatement ps3 = this.connection.prepareStatement(
            "insert ConfiguraFacil.Dependencia (Componente_id, Dependencia_id) values (?, ?);");
        ps3.setInt(1, id);
        for (Integer componenteId : c.getDependencias()) {
            ps3.setInt(2, componenteId);
            ps3.executeUpdate();
        }
        ps3.close();


        // detele antigas incompatibilidades
        PreparedStatement ps4 = this.connection.prepareStatement(
            "delete ConfiguraFacil.Incompatibilidade where Componente_id=?;");
        ps4.setInt(1, id);
        ps4.executeUpdate();
        ps4.close();

        // insert novas incompatibilidades
        PreparedStatement ps5 = this.connection.prepareStatement(
            "insert ConfiguraFacil.Incompatibilidade (Componente_id, Incompatibilidade_id) values (?, ?);");
        ps5.setInt(1, id);
        for (Integer componenteId : c.getDependencias()) {
            ps5.setInt(2, componenteId);
            ps5.executeUpdate();
        }
        ps5.close();
	}
}

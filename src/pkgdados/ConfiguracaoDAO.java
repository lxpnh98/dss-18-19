package pkgdados;

import configurafacil.*;
import java.sql.*;

public class ConfiguracaoDAO extends DAO {

    public ConfiguracaoDAO(Connection c) {
        super(c);
    }

    public void createConfiguracao() throws SQLException {
        Statement s = this.connection.createStatement();
        s.executeUpdate("insert into ConfiguraFacil.Configuracao values (default,\"\",\"\",\"\",\"\",\"\",\"\")");
        s.close();
    }

    public Configuracao getConfiguracaoAtual() throws SQLException {
        int id;

        // get id atual
        Statement s = null;
        ResultSet rs = null;
        try {
            s = this.connection.createStatement();
            rs = s.executeQuery("select id from ConfiguraFacil.Configuracao order by id desc limit 1;");
            if (rs.next()) {
                id = rs.getInt("id");
            } else {
                throw new SQLException("ConfiguraFacil.Configuracao is empty.");
            }
        } finally {
            if (rs != null) rs.close();
            if (s != null) s.close();
        }

        return this.get(id);
	}

	public void setConfiguracaoAtual(Configuracao c) throws SQLException {
        int id;

        // get id
        Statement s = null;
        ResultSet rs = null;
        try {
            s = this.connection.createStatement();
            rs = s.executeQuery("select id from ConfiguraFacil.Configuracao order by id desc limit 1;");
            if (rs.next()) {
                id = rs.getInt("id");
            } else {
                throw new SQLException("ConfiguraFacil.Configuracao is empty.");
            }
        } finally {
            if (rs != null) rs.close();
            if (s != null) s.close();
        }

        // set configuração básica
        PreparedStatement ps1 = this.connection.prepareStatement(
            "update ConfiguraFacil.Configuracao " +
            "set motor=?,pintura=?,jantes=?,pneus=?,detalhes_interiores=?,detalhes_exteriores=? " +
            "where id=?;");
        ps1.setString(1, c.getMotor());
        ps1.setString(2, c.getPintura());
        ps1.setString(3, c.getJantes());
        ps1.setString(4, c.getPneus());
        ps1.setString(5, c.getDetInteriores());
        ps1.setString(6, c.getDetExteriores());
        ps1.setInt(7, id);
        ps1.executeUpdate();
        ps1.close();

        // delete antigos pacotes
        PreparedStatement ps2 = this.connection.prepareStatement("delete from ConfiguraFacil.ConfiguracaoPacote where Configuracao_id=?;");
        ps2.setInt(1, id);
        ps2.executeUpdate();
        ps2.close();

        // add pacotes novos
        PreparedStatement ps3 = this.connection.prepareStatement("insert ConfiguraFacil.ConfiguracaoPacote (Configuracao_id, Pacote_id) values (?, ?);");
        ps3.setInt(1, id);
        for (Integer pacoteId : c.getPacotes()) {
            ps3.setInt(2, pacoteId);
            ps3.executeUpdate();
        }
        ps3.close();

        // delete antigos componentes
        PreparedStatement ps4 = this.connection.prepareStatement("delete from ConfiguraFacil.ConfiguracaoComponente where Configuracao_id=?;");
        ps4.setInt(1, id);
        ps4.executeUpdate();
        ps4.close();

        // add componentes novos
        PreparedStatement ps5 = this.connection.prepareStatement("insert ConfiguraFacil.ConfiguracaoComponente (Configuracao_id, Componente_id) values (?, ?);");
        ps5.setInt(1, id);
        for (Integer componenteId : c.getComponentes()) {
            ps5.setInt(2, componenteId);
            ps5.executeUpdate();
        }
        ps5.close();
	}

    public Configuracao get(int id) throws SQLException {
        Configuracao conf = null;

        // get configuracao básica
        PreparedStatement ps1 = this.connection.prepareStatement("select * from ConfiguraFacil.Configuracao where id = ?;");
        ResultSet rs1 = null;
        ps1.setInt(1, id);
        try {
            rs1 = ps1.executeQuery();
            if (rs1.next()) {
                conf = new Configuracao(rs1.getInt("id"),
                                        rs1.getString("motor"),
                                        rs1.getString("pintura"),
                                        rs1.getString("jantes"),
                                        rs1.getString("pneus"),
                                        rs1.getString("detalhes_interiores"),
                                        rs1.getString("detalhes_exteriores"));
            } else {
                throw new SQLException("ConfiguraFacil.Configuracao is empty.");
            }
        } finally {
            if (rs1 != null) rs1.close();
            ps1.close();
        }

        // get componentes
        PreparedStatement ps2 = this.connection.prepareStatement(
            "select Componente_id as id from ConfiguraFacil.ConfiguracaoComponente where Configuracao_id = ?;");
        ps2.setInt(1, id);
        ResultSet rs2 = ps2.executeQuery();
        while (rs2.next()) {
            conf.addComponente(rs2.getInt("id"));
        }
        rs2.close();
        ps2.close();

        // get pacotes
        PreparedStatement ps3 = this.connection.prepareStatement(
            "select Pacote_id as id from ConfiguraFacil.ConfiguracaoPacote where Configuracao_id = ?;");
        ps3.setInt(1, conf.getId());
        ResultSet rs3 = ps3.executeQuery();
        while (rs3.next()) {
            conf.addComponente(rs3.getInt("id"));
        }
        rs3.close();
        ps3.close();

        return conf;
	}

}

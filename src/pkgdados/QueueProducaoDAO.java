package pkgdados;

import configurafacil.*;
import java.time.*;
import java.sql.*;

public class QueueProducaoDAO extends DAO {

    public QueueProducaoDAO(Connection c) {
        super(c);
    }

	public QueueProducao getQueueProducao() throws SQLException {
        QueueProducao q = new QueueProducao();

        Statement s = this.connection.createStatement();
        ResultSet r = s.executeQuery("select * from Carro order by data asc;");

        while (r.next()) {
            Carro c = new Carro(r.getInt("id"),
                                r.getInt("Cliente_id"),
                                r.getInt("Configuracao_id"),
                                r.getFloat("preco"),
                                r.getTimestamp("data").toLocalDateTime(),
                                r.getBoolean("pronto"));
            //System.out.println(c);
            q.add(c);
        }

        r.close();
        s.close();
        return q;
	}

	public void setQueueProducao(QueueProducao q) throws SQLException {
        // delete carros atuais
        Statement s1 = this.connection.createStatement();
        int rowsDeleted = s1.executeUpdate("delete from ConfiguraFacil.Carro;");
        s1.close();

        // reset auto_increment
        Statement s2 = this.connection.createStatement();
        s2.executeUpdate("alter table ConfiguraFacil.Carro auto_increment = 1;");
        s2.close();

        // insert novos carros
        PreparedStatement ps = this.connection.prepareStatement("insert into ConfiguraFacil.Carro values (default, ?, ?, ?, ?, ?);");
        for (Carro c : q.queue) {
            ps.setInt(1, c.getIdCliente());
            ps.setInt(2, c.getIdConfig());
            ps.setFloat(3, c.getPreco());
            ps.setTimestamp(4, Timestamp.valueOf(c.getDataEncomenda()));
            ps.setBoolean(5, c.getPronto());
            ps.execute();
        }
        ps.close();
	}

}

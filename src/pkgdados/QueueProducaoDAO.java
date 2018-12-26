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
        ResultSet r = s.executeQuery("select * from Carro order by id asc;");

        while (r.next()) {
            Carro c = new Carro(r.getInt("id"), r.getInt("Cliente_id"), r.getInt("Configuracao_id"), r.getFloat("preco"), LocalDateTime.now());
            System.out.println(c);
            q.add(c);
        }

        r.close();
        s.close();
        return q;
	}

	public void setQueueProducao(QueueProducao q) throws SQLException {
        Statement s = this.connection.createStatement();
        int rowsDeleted = s.executeUpdate("delete from ConfiguraFacil.Carro;");
        s.close();

        PreparedStatement ps = this.connection.prepareStatement("insert into ConfiguraFacil.Carro values (default, ?, ?, ?);");

        for (Carro c : q.queue) {
            ps.setInt(1, c.getIdCliente());
            ps.setInt(2, c.getIdConfig());
            ps.setFloat(3, c.getPreco());
            ps.execute();
        }

        ps.close();
	}

}

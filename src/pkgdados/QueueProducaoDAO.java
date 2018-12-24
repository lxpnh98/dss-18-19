package pkgdados;

import configurafacil.*;
import java.sql.*;

public class QueueProducaoDAO extends DAO {

    public QueueProducaoDAO(Connection c) {
        super(c);
    }

	public QueueProducao getQueueProducao() throws SQLException {
        QueueProducao q = new QueueProducao();

        Statement s = this.connection.createStatement();

        ResultSet r = s.executeQuery("select * from Carro;");

        while (r.next()) {
            Carro c = new Carro(r.getInt("id"), r.getInt("Cliente_id"), r.getInt("Configuracao_id"));
            System.out.println(c);
            q.add(c);
        }

        return q;
	}

	public void setQueueProducao(QueueProducao q) throws SQLException {
	}

}

package pkgdados;

import configurafacil.*;
import java.sql.*;

public class QueueProducaoDAO extends DAO {

    public QueueProducaoDAO(Connection c) {
        super(c);
    }

	public QueueProducao getQueueProducao() throws SQLException {
        QueueProducao q = new QueueProducao();
        return null;
	}

	public void setQueueProducao(QueueProducao q) throws SQLException {
	}

}

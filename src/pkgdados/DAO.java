package pkgdados;

import java.sql.Connection;

public class DAO {
    protected Connection connection;

    public DAO(Connection c) {
        this.connection = c;
    }
}

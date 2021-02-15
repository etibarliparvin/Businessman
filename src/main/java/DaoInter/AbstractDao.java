package DaoInter;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {

    public Connection connect() throws Exception {
        String url = "jdbc:mysql://localhost:3306/hamid?serverTimezone = UTC";
        String username = "root";
        String password = "112358";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}

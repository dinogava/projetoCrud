package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conectora {


    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/projetos_de_inovacao";
        Connection connection = DriverManager.getConnection(url, "root", "");

        return connection;
    }


}

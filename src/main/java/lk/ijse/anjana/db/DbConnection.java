package lk.ijse.anjana.db;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    private static DbConnection dbConnection;
    private static Connection con;


    private Properties props=new Properties();



    private DbConnection() throws SQLException {
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shopeka","root","shanuka123");

    }
    public static DbConnection getInstance() throws SQLException {
        return (null==dbConnection)?dbConnection=new DbConnection():dbConnection;
    }
    public Connection getConnection(){

        return con;
    }
}

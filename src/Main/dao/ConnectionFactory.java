package Main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public final static String dataBaseName = "base_de_tritarefas";
    public final static String dataBaseUser = "root";
    public final static String dataBasePassword = "esteban001";
    public static final String ignoreTimezone = "?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";

   public static Connection getConnection(){
        try {
            return DriverManager
                    .getConnection(String.format("jdbc:mysql://localhost:3306/%s?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false",dataBaseName),dataBaseUser,dataBasePassword);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}

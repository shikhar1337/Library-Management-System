package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbManager {
    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","post123");
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.err.println(ex.getClass().getName()+": "+ex.getMessage());
        }

        return conn;
    }
}

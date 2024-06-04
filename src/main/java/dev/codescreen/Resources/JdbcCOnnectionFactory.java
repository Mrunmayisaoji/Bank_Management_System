package dev.codescreen.Resources;

import java.sql.DriverManager;


import java.sql.Connection;

public class JdbcCOnnectionFactory {

    private static Connection conn;
	
	public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    
}

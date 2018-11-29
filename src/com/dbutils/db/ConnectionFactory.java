package com.dbutils.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static Connection conn = null;
	
	public static Connection getConnection(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","root");
        }
        catch (Exception e) {         
            e.printStackTrace();
        }
        return conn;     
    }
    
    
    public static void closeConnection(){
        if (conn != null) {
            try {
                conn.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }      
    }
}

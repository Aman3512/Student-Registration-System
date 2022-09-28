package com.masai.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
       public static Connection ProvideConnection() {
           	
           Connection conn = null;
           
           try {
        	   Class.forName("com.mysql.cj.jdbc.Driver");
		 } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
           
           String url = "jdbc:mysql://localhost:3306/student_registration";
           
           try {
			conn = DriverManager.getConnection(url, "root", "aman");
		} catch (SQLException e) {
			e.printStackTrace();
		}
           
           return conn;
            	
      }

	

}

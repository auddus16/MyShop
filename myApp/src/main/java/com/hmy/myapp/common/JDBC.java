package com.hmy.myapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
	public static Connection getConnection() {
		Connection conn= null;
		String driver="oracle.jdbc.driver.OracleDriver";
	    String url="jdbc:oracle:thin:@localhost:1521:xe";
	    String user="hwang";
	    String password="1234";
		
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url,user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


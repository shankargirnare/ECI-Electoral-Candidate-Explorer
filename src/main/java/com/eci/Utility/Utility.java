package com.eci.Utility;


import java.sql.Connection;
import java.sql.DriverManager;

public class Utility {
	
	private static String url = "jdbc:mysql://localhost:3306/advjava193";
	private static String user = "root";
	private static String pwd = "shiv";
	private static String path = "com.mysql.cj.jdbc.Driver";
	
	private static Connection con = null;

	
	public static Connection createConnection() {

		
		try{
			Class.forName(path);
			con = DriverManager.getConnection(url, user, pwd);
			
			
		}catch (Exception e){
			System.out.println(e);
		}
	return con;
	}
	
}

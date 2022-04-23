package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Data {
	public static Connection dbconnect() {
		try {
			Class.forName("org.mysql.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa", " ");
			return con;

		}catch(Exception e2) {
			System.out.println(e2);
return null;
		}
		
	}

}

package com.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.Admin;

public class Signuploginimpl implements Signuplogininterfaces {

	@Override
	public void adminsignup(Admin signup) {
		try {
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			PreparedStatement pst= con.prepareStatement("insert into adminsignup(adminid,fname,lname,uname,psw) values(?,?,?,?,?)");
			pst.setString(1, signup.getId());
			pst.setString(2, signup.getFname());
			pst.setString(3, signup.getLname());
			pst.setString(4, signup.getUname());
			pst.setString(5, signup.getPassword());
			pst.executeUpdate();




		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean adminlogin(String un, String psw) {
		try {
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			PreparedStatement pst= con.prepareStatement("select uname,psw from adminsignup where uname='"+un+"' and psw='"+psw+"' ");
			ResultSet rs= pst.executeQuery();
			if (rs.next()) {
				return true;
			}




		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

}

package com.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Customer;

public class Customeractionimpl implements Customeraction {

	@Override
	public void addcustomer(Customer add) {
		try {
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			PreparedStatement pst= con.prepareStatement("insert into bankcustomer(fullname,openingbalance,currentbalance) values(?,?,?)");
			pst.setString(1, add.getFullName());
			pst.setFloat(2, add.getOpeningBalance());
			pst.setFloat(3, add.getCurrentbalanace());
			pst.executeUpdate();




		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	@Override
	public boolean depositeamount(int accountnumber, float amount) {
		
		try {
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			PreparedStatement pst= con.prepareStatement("select currentbalance from bankcustomer where accountnumber='"+accountnumber+"'");
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				float currentbalance=(rs.getFloat("currentbalance"));
				currentbalance=currentbalance +amount;
				PreparedStatement pst1= con.prepareStatement("update bankcustomer set currentbalance='"+ currentbalance +"' where accountnumber='"+accountnumber+"'");
				pst1.executeUpdate();
				}
				
			
			




		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean withdrawamount(int accountnumber1,float amount1) {
		try {
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			PreparedStatement pst= con.prepareStatement("select currentbalance from bankcustomer where accountnumber='"+accountnumber1+"'");
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				float currentbalance=(rs.getFloat("currentbalance"));
				if(currentbalance >= amount1) {
				currentbalance = currentbalance - amount1;
				PreparedStatement pst1= con.prepareStatement("update bankcustomer set currentbalance='"+ currentbalance +"' where accountnumber='"+accountnumber1+"'");
				pst1.executeUpdate();
				
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
					

	@Override
	public List<Customer> getall() {
		
		List<Customer> cslist= new ArrayList();
		

		try {
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");		
			 PreparedStatement pst2=conn.prepareStatement("SELECT * FROM BANKCUSTOMER ");
			 ResultSet rs =pst2.executeQuery();
			 while(rs.next()) {
				 Customer cs =new Customer();
			 
				cs.setAccountNumber( rs.getInt("accountnumber"));
				cs.setOpeningBalance( rs.getFloat("openingbalance"));
				cs.setCurrentbalanace(rs.getFloat("currentbalance"));
				 cs.setFullName(rs.getString("fullname"));
				 cslist.add(cs);
			 }
			 

		 
	
} catch (SQLException e) {
	e.printStackTrace();

	}
		return cslist;
		
			}

		
}
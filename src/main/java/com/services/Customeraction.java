package com.services;

import java.util.List;

import com.model.Customer;

public interface Customeraction {
	
	void addcustomer(Customer add);
	boolean depositeamount(int accountnumber,float amount);
	boolean withdrawamount(int accountnumber1,float amount1);
	List<Customer> getall();

}

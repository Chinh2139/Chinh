package com.vti.Service;

import java.util.List;

import com.vti.Entity.Customer;
import com.vti.Form.CustomerFormForCreating;

public interface ICustomerService {

	List<Customer> getAllCustomer();

	Customer getCustomerById(short id);

	Customer createNewCustomer(CustomerFormForCreating newCustomerFoorm);

}

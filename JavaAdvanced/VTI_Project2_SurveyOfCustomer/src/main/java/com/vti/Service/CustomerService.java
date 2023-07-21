package com.vti.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.Entity.Customer;
import com.vti.Form.CustomerFormForCreating;
import com.vti.Repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(short id) {
		// TODO Auto-generated method stub
		return customerRepository.getById(id);
	}

	@Override
	public Customer createNewCustomer(CustomerFormForCreating newCustomerForm) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setEmail(newCustomerForm.getEmail());
		customer.setUsername(newCustomerForm.getUsername());
		customer.setFullname(newCustomerForm.getFullname());
		customer.setAvatarImageName(newCustomerForm.getAvatarImageName());
		customer.setMobile(newCustomerForm.getMobile());
		customer.setAddress(newCustomerForm.getAddress());
		customer.setPassword(newCustomerForm.getPassword());
		customer.setCreateDate(newCustomerForm.getCreateDate());
		Customer newCustomer = customerRepository.save(customer);
		return newCustomer;
	}

}

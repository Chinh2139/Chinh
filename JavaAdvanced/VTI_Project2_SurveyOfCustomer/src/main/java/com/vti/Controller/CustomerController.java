package com.vti.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.DTO.CustomerDto;
import com.vti.Entity.Customer;
import com.vti.Form.CustomerFormForCreating;
import com.vti.Service.ICustomerService;

@RestController
@RequestMapping(value = "api/v3/customer")
@CrossOrigin("*")
public class CustomerController {
	@Autowired
	private ICustomerService CustomerService;

	// get all customer
	@GetMapping()
	public ResponseEntity<?> getAllCustomer() {
		List<Customer> listCustomers = CustomerService.getAllCustomer();
		List<CustomerDto> listCustomerDtos = new ArrayList<>();
		for (Customer customer : listCustomers) {
			CustomerDto customerDto = new CustomerDto();
			customerDto.setId(customer.getId());
			customerDto.setEmail(customer.getEmail());
			customerDto.setUsername(customer.getUsername());
			customerDto.setFullname(customer.getFullname());
			customerDto.setAvatarImageName(customer.getAvatarImageName());
			customerDto.setMobile(customer.getMobile());
			customerDto.setAddress(customer.getAddress());
			customerDto.setCreateDate(customer.getCreateDate());
			listCustomerDtos.add(customerDto);

		}

		return new ResponseEntity<>(listCustomerDtos, HttpStatus.OK);

	}

	// get customer by id
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable(name = "id") short id) {
		try {
			Customer customer = CustomerService.getCustomerById(id);
			CustomerDto customerDto = new CustomerDto();
			customerDto.setId(customer.getId());
			customerDto.setEmail(customer.getEmail());
			customerDto.setUsername(customer.getUsername());
			customerDto.setFullname(customer.getFullname());
			customerDto.setAvatarImageName(customer.getAvatarImageName());
			customerDto.setMobile(customer.getMobile());
			customerDto.setAddress(customer.getAddress());
			customerDto.setCreateDate(customer.getCreateDate());
			return new ResponseEntity<>(customerDto, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>("Not found", HttpStatus.OK);
		}
	}

//	add new Customer
	@PostMapping()
	public ResponseEntity<?> createNewCustomer(@RequestBody CustomerFormForCreating newCustomerForm) {
		try {
			Customer newCustomer = CustomerService.createNewCustomer(newCustomerForm);
			CustomerDto customerDto = new CustomerDto();
//			customerDto.setId(newCustomer.getId());
			customerDto.setEmail(newCustomer.getEmail());
			customerDto.setUsername(newCustomer.getUsername());
			customerDto.setFullname(newCustomer.getFullname());
			customerDto.setAvatarImageName(newCustomer.getAvatarImageName());
			customerDto.setMobile(newCustomer.getMobile());
			customerDto.setAddress(newCustomer.getAddress());
			customerDto.setPassword(newCustomer.getPassword());
			customerDto.setCreateDate(newCustomer.getCreateDate());
			return new ResponseEntity<>(customerDto, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>("Not OK", HttpStatus.BAD_REQUEST);
	}
}

//	Delete Customer

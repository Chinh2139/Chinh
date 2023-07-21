package com.vti.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.Entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Short> {

}

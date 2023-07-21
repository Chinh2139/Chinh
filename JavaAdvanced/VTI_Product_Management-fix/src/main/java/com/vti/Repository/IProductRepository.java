package com.vti.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.Entity.Product;

public interface IProductRepository extends JpaRepository<Product, Short>, JpaSpecificationExecutor<Product> {

}

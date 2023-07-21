package com.vti.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.Entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Short> {

}

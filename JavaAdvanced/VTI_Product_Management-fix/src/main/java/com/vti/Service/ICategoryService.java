package com.vti.Service;

import java.util.List;

import com.vti.Entity.Category;

public interface ICategoryService {

	public List<Category> getAllCategory();

	public Category getCategoryById(Short id);

}

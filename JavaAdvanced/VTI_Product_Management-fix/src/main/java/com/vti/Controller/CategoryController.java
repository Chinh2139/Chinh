package com.vti.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.Dto.CategoryDto;
import com.vti.Entity.Category;
import com.vti.Service.ICategoryService;

@RestController
@RequestMapping(value = "api/v2/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@GetMapping()
	public ResponseEntity<?> getAllCategory() {
		List<Category> categories = categoryService.getAllCategory();
		List<CategoryDto> categoryDtos = new ArrayList<>();

		for (Category category : categories) {
			CategoryDto categoryDto = new CategoryDto();
			categoryDto.setId(category.getId());
			categoryDto.setName(category.getName().toString());
			categoryDtos.add(categoryDto);
		}
		return new ResponseEntity<>(categoryDtos, HttpStatus.OK);

	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<?> getCategoryById(@PathVariable(name = "id") Short id) {
		try {
			Category category = categoryService.getCategoryById(id);
			CategoryDto categoryDto = new CategoryDto();
			categoryDto.setId(category.getId());
			categoryDto.setName(category.getName().toString());
			return new ResponseEntity<>(categoryDto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}

	}
}

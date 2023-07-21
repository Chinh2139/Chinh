package com.vti.controller;

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

import com.vti.dto.DepartmentDto;
import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.service.IDepartmentService;

// http://localhost:8080/ap1/v1/departments

@RestController
@RequestMapping(value = "ap1/v1/departments")
@CrossOrigin("*")

public class DepartmentController {

	@Autowired
	private IDepartmentService departmentService;

//	public DepartmentController() {
//		departmentService = new DepartmentService();
//	}

	@GetMapping()
	public ResponseEntity<?> getAllDepartments() {
// Lấy được danh sách phòng ban
		List<Department> lisDepartments = departmentService.getAllDepartments();
//		for (Department department : lisDepartments) {
//			System.out.println(department);
//		}

		// chuyển đổi dữ liệu
		List<DepartmentDto> listDepartmentDtos = new ArrayList<DepartmentDto>();
		for (Department department : lisDepartments) {
			DepartmentDto departmentDto = new DepartmentDto();
			departmentDto.setName(department.getName());
			listDepartmentDtos.add(departmentDto);

		}
		return new ResponseEntity<>(listDepartmentDtos, HttpStatus.OK);
	}

	// Phương thức lấy phòng ban theo id
	// http://localhost:8080/ap1/v1/departments/6
	@GetMapping(value = "/{idDepartment}")
	public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "idDepartment") short id) {
		Department department = departmentService.getDepartmentByID(id);
		// chuyển đổi kiểu dữ liệu
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setId(department.getId());
		departmentDto.setName(department.getName());
		return new ResponseEntity<>(department, HttpStatus.OK);
	}

// Thêm mới 1 phòng ban
	// http://localhost:8080/ap1/v1/departments
	@PostMapping
	public ResponseEntity<?> getDepartmentByID(@RequestBody DepartmentFormForCreating departmentFormForCreating) {
//		System.out.println(departmentFormForCreating.getName());
		Department department = departmentService.createDepartment(departmentFormForCreating);

		// chuyển đổi kiểu dữ liệu
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setId(department.getId());
		departmentDto.setName(department.getName());

		return new ResponseEntity<>(department, HttpStatus.OK);
	}

}

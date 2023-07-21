package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {
	@Autowired
	private IDepartmentRepository departmentRepository;

	@Override
	public List<Department> getAllDepartments() {

		List<Department> listdDepartments = departmentRepository.findAll();
		return listdDepartments;
	}

	@Override
	public Department getDepartmentByID(short id) {
		Department department = departmentRepository.findById(id).get();
		return department;
	}

	@Override
	public Department createDepartment(DepartmentFormForCreating departmentFormForCreating) {
		Department department = new Department();
		department.setName(departmentFormForCreating.getName());

		Department departmentcreated = departmentRepository.save(department);
		return departmentcreated;
	}

}

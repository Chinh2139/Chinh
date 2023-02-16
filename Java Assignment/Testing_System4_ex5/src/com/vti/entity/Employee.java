package com.vti.entity;

public class Employee extends Staff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private String task;

	public Employee(String address) {
		super();
		this.task = task;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int age, Gender gender, String address, String task) {
		super(name, age, gender, address);
		// TODO Auto-generated constructor stub
		this.task = task;
	}

	@Override
	public String getAddress() {
		return task;
	}

}

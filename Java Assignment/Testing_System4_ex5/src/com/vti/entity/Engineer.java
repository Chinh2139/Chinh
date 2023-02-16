package com.vti.entity;

public class Engineer extends Staff {

	public static void main(String[] args) {

	}

	private String specialize;

	public Engineer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Engineer(String name, int age, Gender gender, String address, String specialize) {
		super(name, age, gender, address);
		// TODO Auto-generated constructor stub
		this.specialize = specialize;
	}

	public Engineer(String specialize) {
		super();
		this.specialize = specialize;
	}

	public String getSpecialize() {
		return specialize;
	}

	public void setSpecialize(String specialize) {
		this.specialize = specialize;
	}

}

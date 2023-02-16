package com.vti.entity;

public class Worker extends Staff {
	public static void main(String[] args) {

	}

	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int rank;

	public Worker(String name, int age, Gender gender, String address, int rank) {
		super(name, age, gender, address);
		// TODO Auto-generated constructor stub
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}

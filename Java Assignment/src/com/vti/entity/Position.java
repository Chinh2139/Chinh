package com.vti.entity;

public class Position {
	public int id;
	public Position_name name;

	public enum Position_name {
		Dev, Test, Scrum, Master, PM
	};
}

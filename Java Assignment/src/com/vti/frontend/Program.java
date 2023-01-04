package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;

public class Program {
	public static void main(String[] args) {
		// Department
		Department dep1 = new Department();
		dep1.id = 1;
		dep1.name = "sale";
		Department dep2 = new Department();
		dep2.id = 2;
		dep2.name = "bảovệ";
		Department dep3 = new Department();
		dep3.id = 3;
		dep3.name = "giámđốc";
		// Position
		Position Po1 = new Position();
		Po1.id = 1;
		Po1.name = "Dev";
		Position Po2 = new Position();
		Po2.id = 2;
		Po2.name = "PM";
		Position Po3 = new Position();
		Po3.id = 3;
		Po3.name = "Master";
		// Account
		Account Ac1 = new Account();
		Ac1.id = 1;
		Ac1.email = "email1@gmail.com";
		Ac1.username = "username1";
		Ac1.fullname = "fullname1";
		Ac1.department = dep1;
		Ac1.position = Po1;
		Ac1.createDate = LocalDate.now();

		Account Ac2 = new Account();
		Ac2.id = 2;
		Ac2.email = "email2@gmail.com";
		Ac2.username = "username2";
		Ac2.fullname = "fullname2";
		Ac2.department = dep2;
		Ac2.position = Po2;
		Ac2.createDate = LocalDate.now();

		Account Ac3 = new Account();
		Ac3.id = 3;
		Ac3.email = "email3@gmail.com";
		Ac3.username = "username3";
		Ac3.fullname = "fullname3";
		Ac3.department = dep3;
		Ac3.position = Po3;
		Ac3.createDate = LocalDate.now();
		// Group
		Group Gr1 = new Group();
		Gr1.id = 1;
		Gr1.groupname = "groupname1";

		Group Gr2 = new Group();
		Gr2.id = 2;
		Gr2.groupname = "groupname2";

		Group Gr3 = new Group();
		Gr3.id = 3;
		Gr3.groupname = "groupname3";

		// In ra thông tin
		// Account 1
		System.out.println("Thông tin Account 1");
		System.out.println("Account1:" + Ac1.id);
		System.out.println("email:" + Ac1.email);
		System.out.println("uername:" + Ac1.username);
		System.out.println("fullname:" + Ac1.fullname);
		System.out.println("department:" + dep1.id);
		System.out.println("createdate:" + LocalDate.now());
		// Account 2
		System.out.println("Thông tin Account 2");
		System.out.println("Account2:" + Ac2.id);
		System.out.println("email:" + Ac2.email);
		System.out.println("uername:" + Ac2.username);
		System.out.println("fullname:" + Ac2.fullname);
		System.out.println("department:" + dep2.id);
		System.out.println("createdate:" + LocalDate.now());
		// Account 3
		System.out.println("Thông tin Account 3");
		System.out.println("Account3:" + Ac3.id);
		System.out.println("email:" + Ac3.email);
		System.out.println("uername:" + Ac3.username);
		System.out.println("fullname:" + Ac3.fullname);
		System.out.println("department:" + dep3.id);
		System.out.println("createdate:" + LocalDate.now());

	}
}

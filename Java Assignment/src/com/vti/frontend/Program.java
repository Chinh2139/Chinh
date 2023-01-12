package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.Position_name;

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
		Po1.name = Position_name.Dev;
		Position Po2 = new Position();
		Po2.id = 2;
		Po2.name = Position_name.Master;
		Position Po3 = new Position();
		Po3.id = 3;
		Po3.name = Position_name.PM;
		// Account
		Account Acc1 = new Account();
		Acc1.id = 1;
		Acc1.email = "email1@gmail.com";
		Acc1.username = "username1";
		Acc1.fullname = "fullname1";
		Acc1.department = dep1;
		Acc1.position = Po1;
		Acc1.createDate = LocalDate.now();

		Account Acc2 = new Account();
		Acc2.id = 2;
		Acc2.email = "email2@gmail.com";
		Acc2.username = "username2";
		Acc2.fullname = "fullname2";
		Acc2.department = dep2;
		Acc2.position = Po2;
		Acc2.createDate = LocalDate.now();

		Account Acc3 = new Account();
		Acc3.id = 3;
		Acc3.email = "email3@gmail.com";
		Acc3.username = "username3";
		Acc3.fullname = "fullname3";
		Acc3.department = dep3;
		Acc3.position = Po3;
		Acc3.createDate = LocalDate.now();
		// Group
		Group Gr1 = new Group();
		Gr1.id = 1;
		Gr1.name = "groupname1";
		Gr1.creator = Acc1;
		Gr1.createDate = LocalDate.now();

		Group Gr2 = new Group();
		Gr2.id = 2;
		Gr2.name = "groupname2";
		Gr2.creator = Acc2;
		Gr2.createDate = LocalDate.now();

		Group Gr3 = new Group();
		Gr3.id = 3;
		Gr3.name = "groupname3";
		Gr3.creator = Acc3;
		Gr3.createDate = LocalDate.now();
// add Account vao group
		Acc1.groups = new Group[] { Gr2, Gr3 };
		Acc2.groups = new Group[] { Gr1, Gr3 };
		Acc3.groups = new Group[] { Gr1 };
//		add Group Account
		Gr1.accounts = new Account[] { Acc1 };
		Gr2.accounts = new Account[] { Acc1, Acc2 };
		Gr3.accounts = new Account[] { Acc2 };

		// Gán Group vào Account
		Group[] ac1Groups = new Group[2];
		ac1Groups[0] = Gr1;
		ac1Groups[1] = Gr2;

		Group[] ac2Groups = { Gr1, Gr2, Gr3 };
		Acc1.groups = ac2Groups;

		// In ra thông tin
		// Account 1
		System.out.println("Thông tin Account 1");
		System.out.println("Account1:" + Acc1.id);
		System.out.println("email:" + Acc1.email);
		System.out.println("uername:" + Acc1.username);
		System.out.println("fullname:" + Acc1.fullname);
		System.out.println("department:" + dep1.id);
		System.out.println("createdate:" + LocalDate.now());
		// Account 2
		System.out.println("Thông tin Account 2");
		System.out.println("Account2:" + Acc2.id);
		System.out.println("email:" + Acc2.email);
		System.out.println("uername:" + Acc2.username);
		System.out.println("fullname:" + Acc2.fullname);
		System.out.println("department:" + dep2.id);
		System.out.println("createdate:" + LocalDate.now());
		// Account 3
		System.out.println("Thông tin Account 3");
		System.out.println("Account3:" + Acc3.id);
		System.out.println("email:" + Acc3.email);
		System.out.println("uername:" + Acc3.username);
		System.out.println("fullname:" + Acc3.fullname);
		System.out.println("department:" + dep3.id);
		System.out.println("createdate:" + LocalDate.now());
		System.out.println(Acc1.groups[0].name);

		System.out.println("---------------------------");

		if (Acc2.department == null) {
			System.out.println("khong co phong ban");

		} else {
			System.out.println("phong ban cua nhan vien nay là " + Acc2.department.name);
		}

		System.out.println("------Tenary-----------------");
		System.out.println(Acc2.department == null ? "khong co phong ban"
				: "phong ban cua nhan vien nay là " + Acc2.department.name);

		// Switch Case
		System.out.println("---------------Switch case------");
		int b = 2;
		switch (b) {
		case 1:
			System.out.println("day la so 1");
			break;
		case 2:
			System.out.println("day la so 2");
			break;
		case 3:
			System.out.println("day la so 3");
			break;
		default:
			System.out.println("day la so khac");
			break;
		}
		System.out.println("----------question 5-------------");

		for (int i = 0; i < 10; i = i + 1) {
			System.out.println(i);
		}

		Department[] depArray3 = { dep1, dep3 };
		int i1 = 0;
		while (i1 < depArray3.length) {
			i1 = i1 + 1;
			System.out.println("thong tin department thu" + i1 + 1);
			System.out.println("");
		}

		// do - white
		int k = 1;
		do {
			System.out.println(k);
			k++;
		} while (k <= 10);
// Jumping
		// Break
		for (int j = 0; j < 10; j++) {
			if (j == 3) {
				break;
			}
			System.out.println(j);
		}
// continue
		for (int j = 0; j < 10; j++) {
			if (j == 3) {
				continue;
			}
			System.out.println(j);
//
		}
	}
}

package com.vti.frontend;

import java.time.LocalDate;
import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.Position_name;

public class bai_2 {
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
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

		System.out.println("--------------------------------------------------------------");
		System.out.println("Question 1:");
		if (Acc2.department == null) {
			System.out.println("\"Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này là ..." + Acc2.department.name);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("Question 2:");
		if (Acc2.groups.length == 0) {
			System.out.println("Nhân viên này chưa có group");
		} else if (Acc2.groups.length == 1) {
			System.out.println("Group của nhân viên" + "này là Java Fresher, C# Fresher");

		} else if (Acc2.groups.length == 3) {
			System.out.println("Nhân viên này là người\r\n" + "quan trọng, tham gia nhiều group");
		} else {
			System.out.println("Nhân viên này là\r\n" + "người hóng chuyện, tham gia tất cả các group");
		}

		System.out.println("---------------------------------------------------------------");
		System.out.println("Question 3");
		System.out.println(Acc2.department == null ? "Nhân viên này chưa có phòng ban"
				: "Phòng ban của nhân viên này là ..." + Acc2.department.name);
		System.out.println("---------------------------------------------------------------");
		System.out.println("Question 4");
		System.out.println(Po2.name == Position_name.Dev ? "Đây là Developer" : "Người này không phải là Developer");
		System.out.println("---------------------------------------------------------------");
		System.out.println("Question 5");
		if (Gr1.accounts == null) {
			System.out.println("nhom khong co thanh vien");
		} else {
			switch (Gr1.accounts.length) {
			case 1:
				System.out.println("nhom co mot thanh vien");
				break;
			case 2:
				System.out.println("nhom co hai thanh vien");
				break;
			case 3:
				System.out.println("nhom co ba thanh vien");
				break;

			default:
				System.out.println("nhom co nhieu thanh vien");
				break;

			}
			// Question 6:
			System.out.println("-----------------------Question 6----------------------------------------");
			switch (Acc2.groups.length) {
			case 0:
				System.out.println("nhan vien nay chua co group");
				break;
			case 1:
				System.out.println("Group của nhân viên này là " + Acc2.groups[0].name);
				break;
			case 2:
				System.out.println("Group của nhân viên này là " + Acc2.groups[0].name + Acc2.groups[1].name);
				break;
			case 3:
				System.out.println("nhan vien nay chua co group");
				break;
			default:
				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group ");
				break;
			}
// Question 7;
			System.out.println("-----------------------Question 7---------");
			switch (Acc1.position.name.toString()) {
			case "Dev":
				System.out.println("Đây là Developer");
				break;

			default:
				System.out.println("Người này không phải là Developer");
				break;
			}
		}
		// Question 8:
		System.out.println("-----------------------Question 8---------");
		Account[] infoAccounts = { Acc1, Acc2, Acc3 };
		for (Account account : infoAccounts) {
			System.out.println(" thong tin account la : " + account.id + " email la: " + account.email
					+ " ten phong ban la: " + account.department.name);

		}

		// Question 13:
		System.out.println("-----------------------Question 13---------");
		Account[] accArray2 = { Acc1, Acc2, Acc3 };
		for (int i = 0; i < accArray2.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " : ");
			System.out.println("Email: " + accArray2[i].email);
			System.out.println("Full name: " + accArray2[i].fullname);
			System.out.println("Phòng ban: " + accArray2[i].department.name);
			if (i == 1) {
				continue;

			}
		}

		// Question 15:
		System.out.println("-----------------------Question 15---------");
		for (int i = 0; i <= 20; i = i + 2) {
			System.out.print(i + " ");

		}

		// Exercise 5:
		// Question 1:

		System.out.println("-----------------------Question 1---------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("moi ban nhap so thu 1 ");
		int a = scanner.nextInt();
		System.out.println("moi ban nhap so thu 2 ");
		int b = scanner.nextInt();
		System.out.println("moi ban nhap so thu 3 ");
		int c = scanner.nextInt();
		// Question 2:
		System.out.println("-----------------------Question 2---------");
		System.out.println("moi ban nhap so thu 4 ");
		float d = scanner.nextFloat();
		System.out.println("moi ban nhap so thu 5 ");
		float e = scanner.nextFloat();
		// Question 3:
		System.out.println("-----------------------Question 3---------");
		System.out.println("moi ban nhap ho : ");
		String f = scanner.next();
		System.out.println("moi ban nhap ten : ");
		String g = scanner.next();

	}
}

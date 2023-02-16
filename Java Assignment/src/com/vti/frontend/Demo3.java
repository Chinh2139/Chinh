package com.vti.frontend;

import java.util.Scanner;

public class Demo3 {
	static Scanner scanner = new Scanner(System.in);

	public void phongban1() {
		System.out.println("thong tin phong ban nay la: ");

	}

	public static void main(String[] args) {

		// viet ra phuong thuc in ra phong ban

		String name = "chinh";
		int age = 30;
		System.out.printf("ten cua toi la %s, tuoi cua toi la %d", name, age);

		while (true) {
			System.out.println("+----------------Menu------------+");
			System.out.println("|moi ban chon phep tinh			 |");
			System.out.println("|1. tinh tong					 |");
			System.out.println("|2. tinh hieu					 |");
			System.out.println("|3. tinh phep nha				 |");
			System.out.println("+--------------------------------+");

			int choosemenu = scanner.nextInt();
			switch (choosemenu) {
			case 1:
				sum();
				break;
			case 2:
				minus();
				break;

			default:
				break;
			}
		}
	}

	// TODO Auto-generated method stub
	// Nhập liệu trong chương trình
	// hãy thực hiện bài toàn tính tổng 2 số
	// int a = 1;
	// int b = 4;
	// int result = a + b;
	// System.out.println("tong 2 so la" + result);
	// Java scanner => hỗ trợ lấy dữ liệu người dùng nhập từ bàn phím
//
	// System.out.println("------------------demo input--------------");

	// bạn hãy thực hiện tạo ra 1 phòng ban mới, với id và tên được người dùng nhập
	// từ bàn phím
	// Scanner scanner2 = new Scanner(System.in);System.out.println("moi ban nhap id
	// moi");
	// int idnew = scanner2.nextInt();System.out.println("moi ban nhap name moi");
	// String newname = scanner2.nextLine();

	// Department departmentnew = new
	// Department();departmentnew.id=idnew;departmentnew.name=newname;

	// chuong trinh tinh phep tru 2 so

	//
	// System.out.println("moi ban nhap vao so 1:");
	// int number1 = scanner2.nextInt();
	// System.out.println("moi ban nhap vao so 2:");
	// int number2 = scanner2.nextInt();
	// System.out.println("ket qua phep cong cua ban la: "+ sum_ab (number1,
	// number2);

	// viet ham sum_ac(int a, intb)
	public static int sum_ab(int a, int b) {
		int result_sum = a + b;
		return result_sum;
	}

// viet ham sum()
	public static void sum() {
		// Scanner scanner = new Scanner(System.in);
		System.out.println("--------------phep tong---------");
		System.out.println("moi ban nhao vao so thu 1: ");
		int a = scanner.nextInt();
		System.out.println("moi ban nhao vao so thu 2: ");
		int b = scanner.nextInt();
		int result = a + b;
		System.out.println(" hieu 2 so laf : " + result);
		// scanner.close();
	}

	// viet ham minus
	public static void minus() {
		// Scanner scanner = new Scanner(System.in);
		System.out.println("--------------phep tru---------");
		System.out.println("moi ban nhao vao so thu 1: ");
		int x = scanner.nextInt();
		System.out.println("moi ban nhao vao so thu 2: ");
		int y = scanner.nextInt();
		int resultminus = x - y;
		System.out.println(" hieu 2 so laf : " + resultminus);
		// scanner.close();
	}
}

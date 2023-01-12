package com.vti.frontend;

import java.util.Scanner;

import com.vti.entity.Department;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Nhập liệu trong chương trình
		// hãy thực hiện bài toàn tính tổng 2 số
		// int a = 1;
		// int b = 4;
		// int result = a + b;
		// System.out.println("tong 2 so la" + result);
		// Java scanner => hỗ trợ lấy dữ liệu người dùng nhập từ bàn phím
		Scanner scanner = new Scanner(System.in);
		System.out.println("moi ban nhap so thu 1:");
		int a = scanner.nextInt(); // stop program, cho nguoi dung nhap so
		System.out.println("so ban vua nhap la " + a);

		System.out.println("moi ban nhap vao so thu 2 ");
		int b = scanner.nextInt();
		int result = a + b;
		System.out.println("tong 2 so la " + result);

		System.out.println("------------------demo input--------------");
		// bạn hãy thực hiện tạo ra 1 phòng ban mới, với id và tên được người dùng nhập
		// từ bàn phím
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("moi ban nhap id moi");
		int idnew = scanner2.nextInt();
		System.out.println("moi ban nhap name moi");
		String newname = scanner2.nextLine();

		Department departmentnew = new Department();
		departmentnew.id = idnew;
		departmentnew.name = newname;

	}

}

package com.vti.fontend;

import java.util.Scanner;

import com.vti.backend.ex5backend;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("+------------------------ Menu -------------------+");
			System.out.printf("|%-49s|%n", "1. Thêm mới cán bộ");
			System.out.printf("|%-49s|%n", "2. Tìm kiếm theo họ tên");
			System.out.printf("|%-49s|%n", "3. Hiện thị thông tin về danh sách các cán bộ");
			System.out.printf("|%-49s|%n", "4. Nhập vào tên của cán bộ và delete cán bộ đó");
			System.out.printf("|%-49s|%n", "5. Thoát khỏi chương trình");
			System.out.println("+-------------------------------------------------+");

			int chooseMenu = scanner.nextInt();
			ex5backend ex5backend = new ex5backend();
			switch (chooseMenu) {
			case 1:
				ex5backend.addStaff();
				break;
			case 2:
				ex5backend.findByName();
				break;
			case 3:
				ex5backend.printListStaff();
				break;
			case 4:
				ex5backend.deletebyName();
				break;
			case 5:
				return;

			default:
				System.out.println("Bạn chọn chưa đúng!!!");
				break;
			}
		}
	}

}

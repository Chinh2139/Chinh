package com.vti.backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.vti.entity.Employee;
import com.vti.entity.Engineer;
import com.vti.entity.Gender;
import com.vti.entity.Staff;
import com.vti.entity.Worker;

public class ex5backend {
	private Scanner scanner = new Scanner(System.in);
	// Khai bao 1 mang dong
	private ArrayList<Staff> staffList = new ArrayList<>();

	// phương thức thêm mới cán bộ: addStaff
	public void addStaff() {
		System.out.println("them moi nhan vien");
		System.out.println("+-------- ban muon them doi tuong nao? -------------------+");
		System.out.printf("|%-49s|%n", "1. Thêm worker");
		System.out.printf("|%-49s|%n", "2. Thêm engineer");
		System.out.printf("|%-49s|%n", "3. Thêm emplyee");
		int choose = scanner.nextInt();
		switch (choose) {
		case 1:
			System.out.println("Thêm worker");
			System.out.println("moi ban nhao ten worker");
			String nameInput = scanner.next();
			System.out.println("nhap vao tuoi cua worker");
			int ageInput = scanner.nextInt();

			System.out.println("moi ban chon gioi tinh worker 1.Male, 2. Female, 3. Unknown");
			int chooseGender = scanner.nextInt();
			Gender genderInput = null;
			switch (chooseGender) {
			case 1:
				genderInput = Gender.male;
				break;
			case 2:
				genderInput = Gender.female;
				break;
			case 3:
				genderInput = Gender.unknown;
				break;
			}
			System.out.println("nhap vao dia chi cua worker");
			String addressInput = scanner.next();
			System.out.println("nhap vao rank cua worker");
			int rankInput = scanner.nextInt();
			Worker worker = new Worker();
			worker.setName(nameInput);
			worker.setAge(ageInput);
			worker.setGender(genderInput);
			worker.setAddress(addressInput);
			worker.setRank(rankInput);

			staffList.add(worker); // them worker vao danh sach
			break;

		case 2:
			System.out.println("Thêm engineer");
			System.out.println("moi ban nhao ten engineer");
			String nameInput2 = scanner.next();
			System.out.println("nhap vao tuoi cua engineer");
			int ageInput2 = scanner.nextInt();

			System.out.println("moi ban chon gioi tinh engineer 1.Male, 2. Female, 3. Unknown");
			int chooseGender2 = scanner.nextInt();
			Gender genderInput2 = null;
			switch (chooseGender2) {
			case 1:
				genderInput = Gender.male;
				break;
			case 2:
				genderInput = Gender.female;
				break;
			case 3:
				genderInput = Gender.unknown;
				break;
			}
			System.out.println("nhap vao dia chi cua engineer");
			String addressInput2 = scanner.next();
			System.out.println("nhap vao rank cua engineer");
			String SpecializeInput = scanner.next();
			Engineer engineer = new Engineer();
			engineer.setName(nameInput2);
			engineer.setAge(ageInput2);
			engineer.setGender(genderInput2);
			engineer.setAddress(addressInput2);
			engineer.setSpecialize(SpecializeInput);

			staffList.add(engineer); // them engineer vao danh sach
			break;

		case 3:
			System.out.println("Thêm employee");
			System.out.println("moi ban nhao ten employee");
			String nameInput3 = scanner.next();
			System.out.println("nhap vao tuoi cua employee");
			int ageInput3 = scanner.nextInt();
			System.out.println("moi ban chon gioi tinh emplyee 1.Male, 2. Female, 3. Unknown");
			int chooseGender3 = scanner.nextInt();
			Gender genderInput3 = null;
			switch (chooseGender3) {
			case 1:
				genderInput = Gender.male;
				break;
			case 2:
				genderInput = Gender.female;
				break;
			case 3:
				genderInput = Gender.unknown;
				break;
			}
			System.out.println("nhap vao dia chi cua employee");
			String addressInput3 = scanner.next();
			System.out.println("nhap vao task cua employee");
			String taskInput = scanner.next();
			Employee employee = new Employee();
			employee.setName(nameInput3);
			employee.setAge(ageInput3);
			employee.setGender(genderInput3);
			employee.setAddress(addressInput3);
			staffList.add(employee); // them worker vao danh sach
			break;

		default:
			break;
		}
	}

	// phương thức tìm kiếm tên nhân viên : findByName()
	public void findByName() {
		System.out.println("tim kiem nhan vien");
		// cho nguoi dung nhap vao ten can tim kiem
		System.out.println("moi ban nhap ten cua nhan vien can tim");
		String nameFind = scanner.next();
		// tu ten nguoi dung nhap tim trong stafflist nhung nhan vien co ten can tim va
		// in ra
		// equals: dùng để so sánh chuỗi thay thế ==
		for (Staff staff : staffList) {
			if (staff.getName().equals(nameFind)) {
				System.out.println(staff.toString());
			}
		}
	}

	// phương thức hiển thị danh sách nhân viên: printListStaff
	public void printListStaff() {
		System.out.println("hien thi danh sach nhan vien");
		for (Staff staff : staffList) {
			System.out.println(staff.toString());
		}
	}

	// phương thức xóa nhân viên: DeletebyName
	public void deletebyName() {
		System.out.println("xoa nhan vien");
		System.out.println("moi ban nhap nhan vien can xoa");
		Iterator<Staff> iterator = staffList.iterator();
		// hasnext(): Nếu còn phần tử thì trả về true
		while (iterator.hasNext()) {
			iterator.next(); // trả về 1 phần tử trong mảng
		}
	}
}

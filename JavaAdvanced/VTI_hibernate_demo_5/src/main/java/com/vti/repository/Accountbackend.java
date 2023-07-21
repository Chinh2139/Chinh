package com.vti.repository;

import java.time.LocalDate;
import java.util.List;

import com.vti.DAO.AccountDAO;
import com.vti.entity.Account;
import com.vti.utils.ScannerUltis;

public class Accountbackend {

	private AccountDAO accountDAO;

	public void AccountBackend() {
		accountDAO = new AccountDAO();
	}

	public void showListAccount() {
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-14s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Possition      | Create Date            |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------------+%n");
		List<Account> listAccounts = accountDAO.getAllAccount();
		for (Account acc : listAccounts) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
					acc.getDepartment().getName(), acc.getPosition().getName(), acc.getCreateDate());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------+%n");

	}

//
	public void getAccountByID() {
		System.out.println("Tìm kiếm Account theo ID");
		System.out.println("Mời bạn nhập vào ID cần tìm");
		int idFind = ScannerUltis.inputIntPositive();
		Account account = accountDAO.getAccountByID((short) idFind);
		if (account != null) {
			String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %n";
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------------+%n");
			System.out.format(
					"|ID  | Email                 | Username        |   FullName            | Department     | Create Date            |%n");
			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------------+%n");

			System.out.format(leftAlignFormat, account.getId(), account.getEmail(), account.getUsername(),
					account.getFullname(), account.getDepartment().getName(), account.getCreateDate());

			System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+------------------------+%n");

		} else {
			System.out.println("Tài khoản này không tồn tại");

		}

	}

	public void createAccount() {
		// TODO Auto-generated method stub

		Account account = new Account();
		System.out.println("mời bạn nhập vào ID mới cho Account cần tạo");
		int newId = ScannerUltis.inputIntPositive();
		System.out.println("mời bạn nhập vào Email cho Account cần tạo");
		String newEmail = ScannerUltis.inputString();
		System.out.println("mời bạn nhập vào Username cho Account cần tạo");
		String newUsername = ScannerUltis.inputString();
		System.out.println("mời bạn nhập vào FullName cho Account cần tạo");
		String newFullName = ScannerUltis.inputString();
		System.out.println("mời bạn nhập vào DepartmentID cho Account cần tạo");
		int newDepartmentID = ScannerUltis.inputIntPositive();
		System.out.println("mời bạn nhập vào PositionID cho Account cần tạo");
		int newPositionID = ScannerUltis.inputIntPositive();
		System.out.println("mời bạn nhập vào CreateDate cho Account cần tạo");
		LocalDate newCreateDate = ScannerUltis.inputLocalDate();
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.CreateAccount(account);

		accountDAO.getAllAccount();
	}

	public void DeleteAccount() {
		// TODO Auto-generated method stub

	}

	public void updateAccount() {
		// TODO Auto-generated method stub

	}

	public void findfullnameById() {
		System.out.println("mời bạn nhập vào id cần tìm");
		int id = ScannerUltis.inputIntPositive();
		String fullnamefind = accountDAO.getFullnameById((short) id);
		System.out.println("Fullname của Account là: ");

	}

	public void getAllAccountCreateMonthNow() {
		System.out.println("Danh sach Account la: ");
		List<Account> accounts = accountDAO.getAllAccountCreateMonthNow();

	}
}

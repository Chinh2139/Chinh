package com.vti.frontend;

import com.vti.repository.Accountbackend;
import com.vti.utils.ScannerUltis;

public class DemoAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Accountbackend accountbackend = new Accountbackend();

		while (true)

		{
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Danh sách Account trên hệ thống");
			System.out.format(leftAlignFormat, "2. Danh sách Account Theo ID");
			System.out.format(leftAlignFormat, "3. Tạo mới Account");
			System.out.format(leftAlignFormat, "4. Xóa Account");
			System.out.format(leftAlignFormat, "5. Update Account");
			System.out.format(leftAlignFormat, "7. getAllAccountCreateMonthNow");
			System.out.format(leftAlignFormat, "6.	Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				accountbackend.showListAccount();
				break;
			case 2:
				accountbackend.getAccountByID();
				break;
			case 3:
				accountbackend.createAccount();
				break;
			case 4:
				accountbackend.DeleteAccount();
				break;
			case 5:
				accountbackend.updateAccount();
				break;
			case 6:
				accountbackend.findfullnameById();
				return;
			case 7:
				accountbackend.getAllAccountCreateMonthNow();
				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}
	}
}

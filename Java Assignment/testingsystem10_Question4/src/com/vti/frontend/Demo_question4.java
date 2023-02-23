package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.CheckdataBackend;
import com.vti.ultis.ScannerUltis;

public class Demo_question4 {

	public static void main(String[] args)
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		CheckdataBackend checkdata = new CheckdataBackend();
		while (true) {
			loadMenuMain();
			System.out.println("Hãy chọn 1.Yes, 2.No để nhận câu trả lời");
			int choose = ScannerUltis.inputIntPositive();
			if (choose == 1) {
				switch (choose = 1) {
				case 1:
					checkdata.question4();
					break;
				default:
					System.out.println("!!! Nhập lại");
					break;

				}
			} else {
				System.out.println("Bạn không muốn trả lời hãy thoát program");

			}

		}
	}

	private static void loadMenuMain() {
		// TODO Auto-generated method stub
		System.out.println("Bạn đang chọn câu hỏi số 4");
		String leftAlignFormat = "| %-72s |%n";
		System.out.format("+---------------------------------------------------+%n");
		System.out.format("|                 Question 4                        |%n");
		System.out.format("+---------------------------------------------------+%n");
	}

}

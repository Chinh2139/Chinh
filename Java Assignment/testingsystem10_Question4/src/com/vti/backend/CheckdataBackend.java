package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.DAO.CheckdataDAO;
import com.vti.ultis.ScannerUltis;

public class CheckdataBackend {
	private CheckdataDAO checkDao;

	public CheckdataBackend() throws FileNotFoundException, IOException {
		super();
		checkDao = new CheckdataDAO();
	}

	public void question4() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Mời bạn nhập vào tên cần check");
		String checkName = ScannerUltis.inputString();
		boolean checkResult = checkDao.ifNameExist(checkName);
		if (checkResult) {
			System.out.println("Tên bạn nhập đã tồn tại");

		} else {
			System.out.println("Tên chưa tồn tại");
		}
	}
}
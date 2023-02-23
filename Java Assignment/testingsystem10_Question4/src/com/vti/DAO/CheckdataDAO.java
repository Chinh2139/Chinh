package com.vti.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.ultis.jdbcUltis;

public class CheckdataDAO {
	private jdbcUltis jdbc;

	public CheckdataDAO() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();

	}

	public boolean ifNameExist(String checkName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sqlString = "SELECT * FROM Department WHERE DepartmentName = ?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sqlString);
		preparedStatement.setNString(1, sqlString);
		ResultSet result = preparedStatement.executeQuery();
		if (result.next()) {
			jdbc.disConnection();
			return true;
		} else {
			return false;
		}

	}

}

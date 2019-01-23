package com.Employee.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	Connection con = null;

	String conUrl = null;

	public DBConnection()

	{

		conUrl = "jdbc:sqlserver://vNTDACWSSQLD002:1433;"
				+ "databaseName=DEV_TEST;user=dev_test_dbo;password=dev_test_dbo123";

	}

	public Connection createConnection()

	{

		try

		{

			con = DriverManager.getConnection(conUrl);

		}

		catch (Exception e)

		{

		}

		return con;

	}
}

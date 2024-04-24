package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.ServletContext;

public class ConnectionDb {

	public static Connection getConnection(ServletContext context) {
		Connection con = null;

		try {
			String driver = context.getInitParameter("driver");
			String url = context.getInitParameter("url");
			String username = context.getInitParameter("username");
			String password = context.getInitParameter("password");

			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

}

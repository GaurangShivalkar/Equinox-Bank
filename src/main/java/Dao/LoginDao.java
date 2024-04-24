package Dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Constants.QueryConstant;
import Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginDao {
	public static User login(String email, String password, Connection con) throws ServletException, IOException {
		User user = null;
		try {
			PreparedStatement pst = con.prepareStatement(QueryConstant.SELECTUSER);

			pst.setString(1, email);
			pst.setString(2, password);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				int UserId = rs.getInt("UserId");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Email = rs.getString("Email");
				String Role = rs.getString("role");
				String CustomerId = rs.getString("CustomerId");

				user = new User(UserId, Username, Password, Email, Role, CustomerId);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return user;

	}
}

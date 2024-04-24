package Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Constants.QueryConstant;
import Model.User;

public class RegisterDao {
	public static int register(User user, Connection con) {
		int rowsUpdate = 0;

		String username = user.getUsername();
		String password = user.getPassword();
		String email = user.getEmail();
		String role = user.getRole();

		try {
			if (!username.isEmpty() && !password.isEmpty() && !email.isEmpty() && !role.isEmpty()) {
				PreparedStatement pst = con.prepareStatement(QueryConstant.INSERTUSER);
				pst.setString(1, username);
				pst.setString(2, password);
				pst.setString(3, email);
				pst.setString(4, role);

				rowsUpdate = pst.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowsUpdate;
	}

}

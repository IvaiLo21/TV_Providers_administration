package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class JdbcCustomerServices {

	static String msg = null;
	protected boolean check;

	// Connection properties
	String burl = "jdbc:mysql://localhost:3306/tv_provider_administration";
	String user = "root";
	String pass = "student1";

	// CustomerAddressUpdater
	public void jdbcAddressUpdateService(String input, String name) throws SQLException {

		Connection con = DriverManager.getConnection(burl, user, pass);

		PreparedStatement st = con.prepareStatement("Update customers set address=? where customer_name=?");

		st.setString(1, input);
		st.setString(2, name);
		st.executeUpdate();
	}

	// CustomerUsernameUpdater
	public void jdbcUsernameServices(String input, String name) throws SQLException {

		Connection con = DriverManager.getConnection(burl, user, pass);

		PreparedStatement st = con.prepareStatement("Update customers set customer_name=? where customer_name=?");

		st.setString(1, input);
		st.setString(2, name);
		st.executeUpdate();
	}

	// CustomerPasswordChanger
	public void jdbcPasswordServices(String input, String name) throws SQLException {

		Connection con = DriverManager.getConnection(burl, user, pass);

		PreparedStatement st = con.prepareStatement("Update customers set customer_pass=? where customer_name=?");

		st.setString(1, input);
		st.setString(2, name);
		st.executeUpdate();
	}

	// CustomerLoginServices
	public boolean jdbcCustomerLog(String userName, String passWord) throws SQLException {

		Connection con = DriverManager.getConnection(burl, user, pass);

		PreparedStatement st = con.prepareStatement(
				"Select customer_name, customer_pass from customers where customer_name=? and customer_pass=?");

		st.setString(1, userName);
		st.setString(2, passWord);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			return true;
		} else
			return false;

	}

	// CustomerRegistrationServices
	public boolean jdbcCustomerReg(String userName, String passWord, String address) throws SQLException {
		check = true;

		Connection con = DriverManager.getConnection(burl, user, pass);

		PreparedStatement st = con.prepareStatement(
				"insert into customers" + "(customer_name, customer_pass, address)" + " values (?, ?, ?)");
		try {
			st.setString(1, userName);
			st.setString(2, passWord);
			st.setString(3, address);
			st.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException Excp) {
			msg = Excp.getMessage();
			check = false;
		}
		return check;
	}

}

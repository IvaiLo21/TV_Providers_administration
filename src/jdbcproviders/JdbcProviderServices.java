package jdbcproviders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

public class JdbcProviderServices {

	static String msg = null;
	protected boolean exists;
	protected boolean dateC;

	// Connection properties
	String url = "jdbc:mysql://localhost:3306/tv_provider_administration";
	String user = "root";
	String pass = "student1";

	// Provider Registration Services
	public void jdbcProvRegister(String userName, String passWord, String serviceC, String number, String date)
			throws SQLException {

		exists = false;
		dateC = false;

		Connection con = DriverManager.getConnection(url, user, pass);

		PreparedStatement st = con.prepareStatement("insert into providers"
				+ "(name_of_provider,provider_pass,service_cost,service_contract_number,service_contract_expiry)"
				+ " values (?,?,?,?,?)");

		try {
			st.setString(1, userName);
			st.setString(2, passWord);
			st.setString(3, serviceC);
			st.setString(4, number);
			st.setString(5, date);
			st.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException Excp) {
			exists = true;
			msg = Excp.getMessage();

		} catch (MysqlDataTruncation DateExcp) {
			dateC = true;
			msg = DateExcp.getMessage();
		}
	}

	// Provider User name Services
	public void jdbcUsernameServices(String input, String name) throws SQLException {
		Connection con = DriverManager.getConnection(url, user, pass);

		PreparedStatement st = con.prepareStatement("Update providers set name_of_provider=? where name_of_provider=?");

		st.setString(1, input);
		st.setString(2, name);
		st.executeUpdate();
	}

	// Provider Increase / Decrease Services
	public void jdbcIncrDcrServices(String input, String name, boolean b) throws SQLException {

		Connection con = DriverManager.getConnection(url, user, pass);

		java.sql.CallableStatement myStmt = null;
		if (b) {
			myStmt = con.prepareCall("{call increase_cost_of_services(?, ?)}");
			System.out
					.println("Calling stored procedure Increase_cost_of_services('" + name + "', " + input + "%" + ")");
		} else {
			myStmt = con.prepareCall("{call Decrease_cost_of_services(?, ?)}");
			System.out.println(
					"Calling stored procedure.  decrease_cost_of_services('" + name + "', " + input + "%" + ")");
		}
		myStmt.setString(1, name);
		myStmt.setString(2, input);
		myStmt.execute();
		System.out.println("Finished calling stored procedure");

	}

	// Provider Pass Changer Services
	public void jdbcPassServices(String input, String name) throws SQLException {
		Connection con = DriverManager.getConnection(url, user, pass);

		PreparedStatement st = con.prepareStatement("Update providers set provider_pass=? where name_of_provider=?");

		st.setString(1, input);
		st.setString(2, name);
		st.executeUpdate();
	}

	// Provider Cost Services
	public void jdbcCostServices(String input, String name) throws SQLException {
		Connection con = DriverManager.getConnection(url, user, pass);

		PreparedStatement st = con.prepareStatement("Update providers set service_cost=? where name_of_provider=?");

		st.setString(1, input);
		st.setString(2, name);
		st.executeUpdate();
	}

	// Provider Expiry Date Services
	public void jdbcEDateServices(String input, String name) throws SQLException {
		Connection con = DriverManager.getConnection(url, user, pass);

		PreparedStatement st = con
				.prepareStatement("Update providers set service_contract_expiry=? where name_of_provider=?");

		st.setString(1, input);
		st.setString(2, name);
		st.executeUpdate();
	}

	// Provider Contract Number Services
	public void jdbcCntrNumbServices(String input, String name) throws SQLException {
		exists = false;
		Connection con = DriverManager.getConnection(url, user, pass);

		PreparedStatement st = con
				.prepareStatement("Update providers set service_contract_number=? where name_of_provider=?");

		try {
			st.setString(1, input);
			st.setString(2, name);
			st.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException Excp) {
			msg = Excp.getMessage();
			exists = true;
		}

	}

	// Provider Login Services
	public boolean jdbcProvLogin(String userName, String passWord) throws SQLException {
		Connection con = DriverManager.getConnection(url, user, pass);

		PreparedStatement st = con.prepareStatement(
				"Select name_of_provider, provider_pass from providers where name_of_provider=? and provider_pass=?");

		st.setString(1, userName);
		st.setString(2, passWord);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			return true;
		} else
			return false;

	}

}

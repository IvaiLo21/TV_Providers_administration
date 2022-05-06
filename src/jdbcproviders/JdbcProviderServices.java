package jdbcproviders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

public class JdbcProviderServices {
	
	static String msg = null;
	static boolean isTrue = false;
	static boolean exists = false;
	static boolean dateC = false;
	
	//Connection properties
		String burl = "jdbc:mysql://localhost:3306/tv_provider_administration";
		String user = "root";
		String pass = "student1";
		
	// Provider Registration Services
		public void jdbcProviderRegistrationServices(String userName,String passWord,String serviceC,String number,String date)throws SQLException{
			
			Connection con = (Connection) DriverManager.getConnection(burl, user, pass);

			PreparedStatement st = con.prepareStatement("insert into providers"
					+ "(name_of_provider,provider_pass,service_cost,contract_number,contract_expiry)"
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
	public void jdbcUsernameServices(String pstr, String name) throws SQLException{
		Connection con = (Connection) DriverManager.getConnection(burl, user, pass);

	PreparedStatement st = (PreparedStatement) con
			.prepareStatement("Update providers set name_of_provider=? where name_of_provider=?");

	st.setString(1, pstr);
	st.setString(2, name);
	st.executeUpdate();
	}
	
	// Provider Increase / Decrease Services
	public void jdbcIncrDcrServices(String pstr, String name, boolean b) throws SQLException{
		
		Connection con = (Connection) DriverManager.getConnection(burl, user, pass);

		java.sql.CallableStatement myStmt = null;
		if (b == true) {
			myStmt = con.prepareCall("{call increase_cost_of_services(?, ?)}");
			System.out.println("Calling stored procedure Increase_cost_of_services('" + name + "', " + pstr
					+ "%" + ")");
		} else {
			myStmt = con.prepareCall("{call Decrease_cost_of_services(?, ?)}");
			System.out.println("Calling stored procedure.  decrease_cost_of_services('" + name + "', "
					+ pstr + "%" + ")");
		}
		myStmt.setString(1, name);
		myStmt.setString(2, pstr);
		myStmt.execute();
		System.out.println("Finished calling stored procedure");
		
	}
	
	
	// Provider Pass Changer Services
	public void jdbcPassServices(String pstr, String name) throws SQLException{
		Connection con = (Connection) DriverManager.getConnection(burl, user, pass);

		PreparedStatement st = (PreparedStatement) con
				.prepareStatement("Update providers set provider_pass=? where name_of_provider=?");

		st.setString(1, pstr);
		st.setString(2, name);
		st.executeUpdate();
	}
	// Provider Cost Services
	public void jdbcCostServices(String pstr, String name) throws SQLException{
		Connection con = (Connection) DriverManager.getConnection(burl, user, pass);

		PreparedStatement st = (PreparedStatement) con
				.prepareStatement("Update providers set service_cost=? where name_of_provider=?");

		st.setString(1, pstr);
		st.setString(2, name);
		st.executeUpdate();
	}
	
	// Provider Expiry Date Services
	public void jdbcEDateServices(String pstr, String name) throws SQLException{
		Connection con = (Connection) DriverManager.getConnection(burl, user, pass);

		PreparedStatement st = (PreparedStatement) con
				.prepareStatement("Update providers set contract_expiry=? where name_of_provider=?");

		st.setString(1, pstr);
		st.setString(2, name);
		st.executeUpdate();
	}
	
	// Provider Contract Number Services
	public void jdbcCntrNumbServices(String pstr, String name) throws SQLException{
		Connection con = (Connection) DriverManager.getConnection(burl, user, pass);

		PreparedStatement st = (PreparedStatement) con
				.prepareStatement("Update providers set contract_number=? where name_of_provider=?");
		
		try {
			st.setString(1, pstr);
			st.setString(2, name);
			st.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException Excp) {
			msg = Excp.getMessage();
			isTrue = true;
		}

	}
	

}

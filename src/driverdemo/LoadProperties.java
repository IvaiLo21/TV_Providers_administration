package driverdemo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class LoadProperties {
	public void LoadProps() throws Exception {

		FileInputStream fis = new FileInputStream("config.properties");
		Properties p = new Properties();
		p.load(fis);
		String dname = (String) p.get("Dname");
		String url = (String) p.get("URL");
		String user = (String) p.get("Uname");
		String pass = (String) p.get("password");
		Class.forName(dname);
		Connection con = DriverManager.getConnection(url, user, pass);
		con.close();
	}
}

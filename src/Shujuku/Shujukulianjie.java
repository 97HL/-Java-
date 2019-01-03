package Shujuku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Shujukulianjie {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/examsystem";
	String user = "root";
	String password = "123456";
	public Connection conn = null;
	public Shujukulianjie() throws ClassNotFoundException, SQLException{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
	       
	}

	
	
}

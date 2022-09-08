package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/animal?useSSL=false&useUnicode=true&amp;characterEncoding=utf-8",
				"darrenH",
				"3249"
			);
		
	}
}
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Main {

	public static void main(String[] args) {
		String username = "root";
		String password = "";
		String dbLocation = "jdbc:mysql://localhost/testdb";
		Connection dbConnection = null;
		Statement stmtToBeExecuted = null;
		String query = "select * from testtable";  
		
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Load Done");
		} catch (ClassNotFoundException e) {
			
			System.out.println("Driver Loading Problem");
		}
		
		try {
			dbConnection = (Connection) DriverManager.getConnection(dbLocation, username, password);
			System.out.println("Connection Done");
		} catch (SQLException e) {
			System.out.println("Connection Problem");
		}
		
		try {
			stmtToBeExecuted = (Statement) dbConnection.createStatement();
			System.out.println("Statement Done");
		} catch (SQLException e) {
			System.out.println("Statement Problem");
		}
		
		try {
			rs = stmtToBeExecuted.executeQuery(query);
			System.out.println("Query Done");
		} catch (SQLException e) {
			System.out.println("Query Problem");
		}
		
		try {
			System.out.println(rs.wasNull());
			while(rs.next()){
				System.out.println("Process RS");
				System.out.println(rs.getString(1)+ "\t" +rs.getInt(2) + "\t" +rs.getString(3) + "\t" +rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("Unable to process result set");
		}
	}

}

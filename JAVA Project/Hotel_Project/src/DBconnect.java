import java.sql.*;
public class DBconnect {
	public Connection conn = null;
	public Statement stm;
	public ResultSet rs;
	private String url = "jdbc:mysql://localhost/hotel_db";
	private String username = "root";
	private String password = "";
	public DBconnect(){
		try {
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("Successfully!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public ResultSet getConnect(String sql) {
		try {
			
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			System.out.println("Select Successfully!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public void getUpdate(String sql) {
		try {
			stm = conn.createStatement();
			stm.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void disconnect() {
		try {
			stm.close();
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

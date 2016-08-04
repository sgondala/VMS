package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import beans.User;

public class UserDAO {
	
	public static boolean authenticate(User u) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "Select * from usertable where userid = ? and password = ? and type = ?";
			ps = conn.prepareStatement(queryStatement);
			ps.setString(1, u.getUserId());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getType());
			rs = ps.executeQuery();				
			boolean isExists;
			if(rs.next()){
				isExists = true;
			}
			else{
				isExists = false;
			}
			conn.close();
			ps.close();
			rs.close();
			return isExists;		
		} catch (Exception e) {
			conn.close();
			ps.close();
			rs.close();
			e.printStackTrace();
			return false;
		}
	}
	
	public static int add(User u) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "insert into usertable(userid, password, name, type, age, gender, mailid) values(?,?,?,?,?,?,?);";
			ps = conn.prepareStatement(queryStatement);
			ps.setString(1,u.getUserId());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getName());
			ps.setString(4, u.getType());
			ps.setInt(5, u.getAge());
			ps.setString(6, String.valueOf(u.getGender()));
			ps.setString(7, u.getMailId());
			int result = ps.executeUpdate();
			
			conn.close();
			ps.close();
			return result;
			
		} catch (Exception e2) {
			ps.close();
			conn.close();
			e2.printStackTrace();
			return -1;
		}
	}
	
}

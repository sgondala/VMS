package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Driver;
import beans.Employee;

public class DriverDAO {
	public static int add(Driver d) throws Exception{
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				UserDAO.add(d);
				Class.forName(Constants.DRIVERNAME);
				conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
				String queryStatement = "insert into driver(userid, drivinglicense) values(?,?);";
				ps = conn.prepareStatement(queryStatement);
				ps.setString(1, d.getUserId());
				ps.setString(2, d.getDrivingLicense());
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

	public static ArrayList<Driver> viewAll() throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "select * from driver join employee on driver.userid = employee.userid join usertable on usertable.userid = employee.userid;";
			ps = conn.prepareStatement(queryStatement);
			rs = ps.executeQuery();
			
			ArrayList<Driver> returnList = new ArrayList<>();
			while(rs.next()){
				Driver d1 = new Driver(rs.getString("userid"), rs.getString("password"), rs.getString("name"), rs.getString("type"), rs.getInt("age"), rs.getString("gender").charAt(0), rs.getString("mailid"),rs.getString("drivinglicense"));
				returnList.add(d1);
			}
			
			conn.close();
			ps.close();
			rs.close();
			return returnList;
			
		} catch (Exception e2) {
			rs.close();
			ps.close();
			conn.close();
			e2.printStackTrace();
			return null;
		}
	}
}

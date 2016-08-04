package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Passenger;

public class PassengerDAO {
	public static ArrayList<Passenger> viewAll() throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			
			String queryStatement = "select * from usertable where type ='Passenger'";
			ps = conn.prepareStatement(queryStatement);
			rs = ps.executeQuery();
			
			ArrayList<Passenger> returnList = new ArrayList<>();
			while(rs.next()){
				Passenger p1 = new Passenger(rs.getString("userid"), rs.getString("password"), rs.getString("name"), rs.getString("type"), rs.getInt("age"), rs.getString("gender").charAt(0), rs.getString("mailid"));
				returnList.add(p1);
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
	
	public static Passenger view(String userid) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "select * from usertable where userid = ? and type='Passenger'";
			ps = conn.prepareStatement(queryStatement);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			Passenger returnPassenger = null;
			if(rs.next()){
				Passenger p1 = new Passenger(rs.getString("userid"), rs.getString("password"), rs.getString("name"), rs.getString("type"), rs.getInt("age"), rs.getString("gender").charAt(0), rs.getString("mailid"));
				returnPassenger = p1;
			}
			
			conn.close();
			ps.close();
			rs.close();
			return returnPassenger;
			
		} catch (Exception e2) {
			rs.close();
			ps.close();
			conn.close();
			e2.printStackTrace();
			return null;
		}
		
	}
	
	public static int delete(String passengerId) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "delete from usertable where userid = ?";
			ps = conn.prepareStatement(queryStatement);
			ps.setString(1, passengerId);
			int returnVal = ps.executeUpdate();
			conn.close();
			ps.close();
			return returnVal;
		} catch (Exception e2) {
			ps.close();
			conn.close();
			e2.printStackTrace();
			return -1;
		}
	}

	public static int add(Passenger p) throws Exception{
		UserDAO.add(p);
		return -1; 
	}
}

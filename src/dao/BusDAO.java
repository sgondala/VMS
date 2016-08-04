package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Bus;

public class BusDAO {
	
	public static int add(Bus b) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "insert into bus(BUSNUMBER, REGISTRATIONNUMBER, MODEL, SEATINGCAPACITY) values(?,?,?,?);";
			ps = conn.prepareStatement(queryStatement);
			ps.setString(1, b.getBusNumber());
			ps.setString(2, b.getRegistrationNumber());
			ps.setString(3, b.getModel());
			ps.setInt(4, b.getSeatingCapacity());
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
	
	public static ArrayList<Bus> viewAll() throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "select * from bus";
			ps = conn.prepareStatement(queryStatement);
			rs = ps.executeQuery();
			
			ArrayList<Bus> returnList = new ArrayList<>();
			while(rs.next()){
				Bus b1 = new Bus(rs.getString("busnumber"), rs.getString("REGISTRATIONNUMBER"), rs.getString("MODEL"), 
						rs.getInt("SEATINGCAPACITY"));
				returnList.add(b1);
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

	public static Bus view(String busNumber) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "select * from bus where busnumber = ?";
			ps = conn.prepareStatement(queryStatement);
			ps.setString(1, busNumber);
			rs = ps.executeQuery();
			
			Bus returnBus = null;
			if(rs.next()){
				Bus b1 = new Bus(rs.getString("busnumber"), rs.getString("registrationNumber"), 
						rs.getString("model"), rs.getInt("seatingCapacity"));
				returnBus= b1;
			}
			
			conn.close();
			ps.close();
			rs.close();
			return returnBus;
			
		} catch (Exception e2) {
			rs.close();
			ps.close();
			conn.close();
			e2.printStackTrace();
			return null;
		}
	}
}

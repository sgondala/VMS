package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Route;

public class RouteDAO {
	public static int add(Route r) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "insert into route(routeid, routename, source, destination, distance, fare)"
					+ " values(?,?,?,?,?,?);";
			ps = conn.prepareStatement(queryStatement);
			ps.setString(1,r.getRouteId());
			ps.setString(2,r.getRouteName());
			ps.setString(3, r.getSource());
			ps.setString(4, r.getDestination());
			ps.setInt(5, r.getDistance());
			ps.setInt(6, r.getFare());
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
	
	public static Route view(String routeId) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "select * from route where routeid = ?";
			ps = conn.prepareStatement(queryStatement);
			ps.setString(1, routeId);
			rs = ps.executeQuery();
			
			Route returnRoute = null;
			if(rs.next()){
				Route r1 = new Route(rs.getString("routeid"), rs.getString("routename"), rs.getString("source"),
						rs.getString("destination"),rs.getInt("distance"), rs.getInt("fare"));
				returnRoute = r1;
			}
			
			conn.close();
			ps.close();
			rs.close();
			return returnRoute;
			
		} catch (Exception e2) {
			rs.close();
			ps.close();
			conn.close();
			e2.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<Route> viewAll(String routeId) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "select * from route";
			ps = conn.prepareStatement(queryStatement);
			ps.setString(1, routeId);
			rs = ps.executeQuery();
			
			
			ArrayList<Route> returnRoute = new ArrayList<>();
			while(rs.next()){
				Route r1 = new Route(rs.getString("routeid"), rs.getString("routename"), rs.getString("source"),
						rs.getString("destination"),rs.getInt("distance"), rs.getInt("fare"));
				returnRoute.add(r1);
			}
			
			conn.close();
			ps.close();
			rs.close();
			return returnRoute;
			
		} catch (Exception e2) {
			rs.close();
			ps.close();
			conn.close();
			e2.printStackTrace();
			return null;
		}
	}
}

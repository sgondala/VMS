package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Employee;

public class EmployeeDAO {
	
	public static int add(Employee e) throws Exception
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			UserDAO.add(e);
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "insert into employee(employeeId, salary, userId) values(?,?,?);";
			ps = conn.prepareStatement(queryStatement);
			ps.setString(1,e.getEmployeeId());
			ps.setInt(2, e.getSalary());
			ps.setString(3, e.getUserId());
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

	public static ArrayList<Employee> viewAll() throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "select * from employee join usertable on usertable.userid = employee.userid";
			ps = conn.prepareStatement(queryStatement);
			rs = ps.executeQuery();
			
			ArrayList<Employee> returnList = new ArrayList<>();
			while(rs.next()){
				Employee e1 = new Employee(rs.getString("userId"), rs.getString("password"), rs.getString("name"), 
						rs.getString("type"), rs.getInt("age"), rs.getString("gender").charAt(0), rs.getString("mailid"), 
						rs.getInt("salary"), rs.getString("employeeId"));
				returnList.add(e1);
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

	public static Employee view(String employeeId) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "select * from employee join usertable on "
					+ "usertable.userid = employee.userid where employeeid = ?";
			ps = conn.prepareStatement(queryStatement);
			ps.setString(1, employeeId);
			rs = ps.executeQuery();
			
			Employee returnEmployee = null;
			if(rs.next()){
				Employee e1 = new Employee(rs.getString("userId"), rs.getString("password"), rs.getString("name"), 
						rs.getString("type"), rs.getInt("age"), rs.getString("gender").charAt(0), rs.getString("mailid"), 
						rs.getInt("salary"), rs.getString("employeeId"));
				returnEmployee = e1;
			}
			
			conn.close();
			ps.close();
			rs.close();
			return returnEmployee;
			
		} catch (Exception e2) {
			rs.close();
			ps.close();
			conn.close();
			e2.printStackTrace();
			return null;
		}
	}

	public static int delete(String employeeId) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Constants.DRIVERNAME);
			conn = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
			String queryStatement = "select * from employee where employeeid = ?";
			ps = conn.prepareStatement(queryStatement);
			ps.setString(1, employeeId);
			rs = ps.executeQuery();
			
			int returnVal = -1;
			if(rs.next()){
				String userId = rs.getString("userid");
				queryStatement = "delete from usertable where userid = ?";
				ps = conn.prepareStatement(queryStatement);
				ps.setString(1, userId);
				returnVal = ps.executeUpdate();
			}
			
			conn.close();
			ps.close();
			rs.close();
			return returnVal;
			
		} catch (Exception e2) {
			rs.close();
			ps.close();
			conn.close();
			e2.printStackTrace();
			return -1;
		}
	}
	
}


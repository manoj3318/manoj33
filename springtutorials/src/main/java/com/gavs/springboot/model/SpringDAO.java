package com.gavs.springboot.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 import com.gavs.springboot.model.Employee;
 
public class SpringDAO {
	
	
	public static Connection myConnection() {
		String MYSQL_DRIVERNAME="com.mysql.cj.jdbc.Driver";
		String MYSQL_CONNECTION_URL="jdbc:mysql://localhost:3306/employee";
		String strUserName="root";
        String strPassword="admin";
        try {
			Class.forName(MYSQL_DRIVERNAME);
			return DriverManager.getConnection(MYSQL_CONNECTION_URL,strUserName,strPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public int addEmployee(Employee emp) {
		int emp_id = emp.getId();
		String emp_name =emp.getName();
		
		try {
			String sql = "INSERT INTO emp VALUES (?,?)";
			PreparedStatement preparestatement = myConnection().prepareStatement(sql);
			preparestatement.setInt(1,emp_id );
			preparestatement.setString(2,emp_name );
			int result =preparestatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			if (myConnection() != null) {
				try {
					myConnection().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}return 1;
		
		
	}
	
	public static Employee fetchEmployee(Employee emp) throws  Exception {
		ResultSet resultSet = null;
		
		try {
			String sql = "SELECT * FROM emp";
			Statement createstatement = myConnection().createStatement();
			resultSet = createstatement.executeQuery(sql);
			
			while(resultSet.next()) {
			emp.setId(resultSet.getInt(1));
			emp.setName(resultSet.getString(2));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (myConnection() != null) {
				myConnection().close();
			}
		}return emp;
	}
	
		
	public static int modifyEmployee(Employee emp)throws  Exception {
		try {
			String sql = "UPDATE emp set emp_name=? where emp_id=?";
			PreparedStatement preparestatement = myConnection().prepareStatement(sql);
			preparestatement.setString(1, emp.getName());
			preparestatement.setInt(2, emp.getId());
			
			
			int a = preparestatement.executeUpdate();
			return a;
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			if (myConnection() != null) {
				myConnection().close();
			}
		}
		return 1;
	}
	
	public static int deleteEmployee(Employee emp) throws SQLException, Exception {
		try {
			String sql = "DELETE FROM emp where emp_id =?";
			PreparedStatement preparestatement = myConnection().prepareStatement(sql);
			preparestatement.setInt(1,emp.getId());
			//preparestatement.setString(1,emp.getName());
			
			int delres =preparestatement.executeUpdate();
			return delres;
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if (myConnection() != null) {
				myConnection().close();
			}
		}return 1;
	}
	}
		
	



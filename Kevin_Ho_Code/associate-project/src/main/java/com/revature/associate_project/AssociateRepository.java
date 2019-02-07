package com.revature.associate_project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class AssociateRepository {

	
	public int getBestAssociate() {
		return 0;
	}
	
	public Associate getById(int id) {
		Associate a = new Associate();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "{ call getAssociateById(?, ?) }";
			CallableStatement cs = conn.prepareCall(query);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.setInt(2, id);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			if(rs.next()) {
				a = new Associate();
				a.setId(rs.getInt("associates_id"));
				a.setFirstName(rs.getString("first_name"));
				a.setLastName(rs.getString("last_name"));
				a.setEmail(rs.getString("email"));
				a.setPassword(rs.getString("pass"));
				a.setGrade(rs.getDouble("grade"));
			}
			else {
				return null;
				//no associate with this ID
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return a;
	}
	
	public Associate getByEmail(String email) {
		Associate a = new Associate();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from associates where email = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a = new Associate();
				a.setId(rs.getInt("associates_id"));
				a.setFirstName(rs.getString("first_name"));
				a.setLastName(rs.getString("last_name"));
				a.setEmail(rs.getString("email"));
				a.setPassword(rs.getString("pass"));
				a.setGrade(rs.getDouble("grade"));
			}
			else {
				return null;
				//no associate with this email
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public Associate update(Associate a) {
		return null;
	}
	
	public Associate save(Associate a) {
		return null;
	}
	public boolean logIn(Scanner console)
	{
		System.out.println("Enter your Username");
		String username = console.nextLine();
		System.out.println("Enter your Password");
		String password = console.nextLine();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select email,pass from associates where email = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString("email").equals(username)&&
						rs.getString("pass").equals(password);
			}
			else {
				return false;
				//no associate with this email
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	public boolean UserExists(String x)
	{
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select email from associates where email = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, x.toLowerCase());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				rs.getString("email").equals(x);
				return true;
			}
			else {
				return false;
				//no associate with this email
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean createAssociate(Scanner console)
	{
		try{
			System.out.println("Enter your Email");
			String username = console.nextLine();
			if(UserExists(username))
				return false;
			System.out.println("Enter your Password");
			String password = console.nextLine();
			System.out.println("Enter your First Name");
			String first_name = console.nextLine();
			System.out.println("Enter your Last Name");
			String last_name = console.nextLine();
			System.out.println("Enter your Grade");
			double grade = Double.parseDouble(console.nextLine());
			int a=0;
			
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				conn.setAutoCommit(false);
				PreparedStatement insertUser = null;
				String query = "INSERT INTO associates (email, pass, first_name,"
													+ "last_name, grade)"
								+ "VALUES (?,?,?,?,?)";
						
				insertUser = conn.prepareStatement(query);
				insertUser.setString(1, username);
				insertUser.setString(2, password);
				insertUser.setString(3, first_name);
				insertUser.setString(4, last_name);
				insertUser.setDouble(5, grade);
				
				insertUser.executeUpdate();
				conn.commit();
				insertUser.close();
				return true;
			}
			 catch (SQLException e){
				e.printStackTrace();
			}
		} catch(InputMismatchException e){
		System.out.println("Invalid Input. Try again.");
		}
		return false;
	}

	public void checkGrades()
	{
		double grades = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select grade from associates";
			CallableStatement cs = conn.prepareCall(query);
			cs.execute();
			ResultSet rs = cs.getResultSet();
			while(rs.next()) {
				grades += rs.getDouble("grade");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Grades = " + grades);
	}
}
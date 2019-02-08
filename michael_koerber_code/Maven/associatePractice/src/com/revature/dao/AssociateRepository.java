package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.jdbc.util.ConnectionFactory;
import com.revature.exceptions.UserNotFound;
import com.revature.pojo.Associate;

public class AssociateRepository {
	public Associate logIn(String email, String password) throws UserNotFound{
		Associate temp = new Associate();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "SELECT * FROM associates WHERE email = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				temp = new Associate(rs.getString(2), rs.getString(3), 
						email, password, rs.getDouble(6));
			} else {
				throw new UserNotFound();
			}
		} catch (SQLException e) {
			
		}
		return temp;
	}
	
	public Associate createAssociate(Associate a){
		Associate temp = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "INSERT INTO associates(firstname, lastname, email, password, grade) "
					+ "VALUES (?, ?, ?, ?, ?)";
		
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, a.getFirstname());
			ps.setString(2, a.getLastname());
			ps.setString(3, a.getEmail());
			ps.setString(4, a.getPassword());
			ps.setDouble(5,  0);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				temp = new Associate(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getDouble(5));
			}
			
		} catch (SQLException e) {
			
		}
		return temp;
	}
	
	public boolean validateEmail(String email){
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT email FROM associates WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public Associate updateAssociateInfo(ArrayList<String> updateList, String updateValue, int index){
		Associate temp = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			switch(index){
			case 0:{
				String query = "UPDATE associates SET firstname = ? WHERE email = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, updateValue);
				ps.setString(2, updateList.get(2));
				ps.executeUpdate();
				break;
			}
			case 1:{
				String query = "UPDATE associates SET lastname = ? WHERE email = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, updateValue);
				ps.setString(2, updateList.get(2));
				ps.executeUpdate();
				break;
			}
			case 2:{
				String query = "UPDATE associates SET email = ? WHERE email = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, updateValue);
				ps.setString(2, updateList.get(2));
				ps.executeUpdate();
				break;
			}
			case 3:{
				String query = "UPDATE associates SET password = ? WHERE email = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, updateValue);
				ps.setString(2, updateList.get(2));
				ps.executeUpdate();
				break;
			}
			}
			
		} catch (SQLException e) {
			
		}
		return temp;
	}
}

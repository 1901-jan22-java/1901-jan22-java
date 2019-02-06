package com.ravature.bank.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.jdbc.util.ConnectionFactory;
import com.ravature.bank.pojos.Account;
import com.ravature.bank.pojos.User;
import com.ravature.bank.views.ViewAcc;
public class RepositoryForAccount {
	public static List<Account> getAccounts(int User_ID) {
		List<Account> accounts = new ArrayList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from accounts where userid = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, User_ID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Account acc1 = new Account();
				acc1.setAccountId(rs.getInt(1));
				acc1.setAccountType(rs.getString(2));
				acc1.setBalance(rs.getDouble(3));
				acc1.setUserId(rs.getInt(4));
				accounts.add(acc1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
public static double getBalance(int User_Id){
	   Account acc2 = null;
	   try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		   String query = "select * from accounts where userId = ?";
		   PreparedStatement ps = conn.prepareStatement(query);
		   ps.setInt(1, User_Id);
		   ResultSet rs = ps.executeQuery(); 
		   if(rs.next()) {
			   acc2 = new Account();
			   acc2.setAccountId(rs.getInt(1));
			   acc2.setAccountType(rs.getString(2));
			   acc2.setBalance(rs.getDouble(3));
			   acc2.setUserId(rs.getInt(4));
			} 
	   } catch (SQLException e) {
		e.printStackTrace();
	}
	   return acc2.getBalance();
}
	public static Account save(int account_id, Account newAccount, User loggedInUser) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "insert into accounts(account_id, user_id, account_type, balance) values (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, loggedInUser.getUser_Id());
			ps.setString(2, newAccount.getAccountType());
			ps.setDouble(3, 0d);
			int numRows = ps.executeUpdate();
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				newAccount.setUserId(pk.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("You have Created a new Account");
		return newAccount;
	}
	public static void Deposit(int specificAccount, double depositAmount){
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "update accounts set balance = balance + ? where accountId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1,  depositAmount);
			ps.setInt(2,  specificAccount);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static boolean Withdraw(int withdrawAccount, double withdrawAmount, User currUser){
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "update accounts set balance = balance - ? where accountId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, withdrawAmount);
			ps.setInt(2, withdrawAccount);
			if(getBalance(currUser.getUser_Id()) - withdrawAmount < 0){
				System.out.println("Insuffient Funds");
				ViewAcc.initiateWithdrawal(currUser);
				return false;
			} else {
				ps.executeUpdate();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}
}
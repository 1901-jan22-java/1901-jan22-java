package com.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.main.RevatureBankApp;

public class DataFactory {

	// Create new User for Bank

	public void createUser(String fn, String ln, String password, String email) {
		String query = "INSERT INTO REVATUREBANKUSER (FIRSTNAME, LASTNAME, USERPASSWORD, EMAIL) VALUES (?, ?, ?, ?)";
		PreparedStatement ps;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			ps = conn.prepareStatement(query);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, password);
			ps.setString(4, email);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// log in

	public String[] login(String email, String pw) {
		String query = "SELECT * FROM REVATUREBANKUSER WHERE email = ? AND userpassword = ?";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new String[] { rs.getString("userid"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
					rs.getString("EMAIL"), rs.getString("USERPASSWORD")

			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Incorrect Username or Password");
			RevatureBankApp.logIn();
		}
		return null;

	}

	// check if account is there upon login

	// View Account details preferable current account details
	public void getAllBankUsers(String email) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM REVATUREBANKACCOUNT WHERE email ='" + email + "'";
			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				String type = rs.getString("ACCOUNTTYPE");
				System.out.println(type);
				String pw = rs.getString("AMOUNT");
				System.out.println(pw);
				
				
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("You have not saving or checking account.");
		}
		RevatureBankApp.acctPage(email);
	}

	// Create new account type

	public void createCheckingAccount(String email) {
		String query = "INSERT INTO REVATUREBANKACCOUNT (EMAIL, ACCOUNTTYPE, AMOUNT) VALUES (?, 'CHECKINGS', 0)";
		PreparedStatement ps;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.executeUpdate();
			System.out.println("You have a Checking Account!");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void createSavingAccount(String email) {
		String query = "INSERT INTO REVATUREBANKACCOUNT (EMAIL, ACCOUNTTYPE, AMOUNT) VALUES (?, 'SAVINGS', 0)";
		PreparedStatement ps;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.executeUpdate();
			System.out.println("You have a Savings Account!");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Withdraw

	public void updateDepositChecking(String email, double amount) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE REVATUREBANKACCOUNT set amount = ? WHERE email = ? AND ACCOUNTTYPE = 'CHECKINGS'";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, amount);
			ps.setString(2, email);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateDepositSaving(String email, double amount) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE REVATUREBANKACCOUNT set amount = ? WHERE email = ? AND ACCOUNTTYPE = 'SAVINGS'";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, amount);
			ps.setString(2, email);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public double getAmount(String email) {
		int value = 0;
		String query = "SELECT * FROM REVATUREBANKACCOUNT WHERE email = ?";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next())

			{

				rs.getString("EMAIL");
				value = rs.getInt("AMOUNT");

			}
			;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}

}

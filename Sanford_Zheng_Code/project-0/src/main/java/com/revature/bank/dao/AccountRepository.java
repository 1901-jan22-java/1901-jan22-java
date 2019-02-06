package com.revature.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.jdbc.util.ConnectionFactory;
import com.revature.bank.exceptions.InsufficientFundsException;
import com.revature.bank.exceptions.NoSuchBankAccountException;
import com.revature.bank.exceptions.NonPositiveAmountException;
import com.revature.bank.exceptions.UnableToGenerateKeyException;
import com.revature.bank.pojos.Account;

public class AccountRepository {

	private static final Logger logger = Logger.getLogger(AccountRepository.class);

	public static void addAccount(Integer userID, Integer typeID, Double balance) throws
			UnableToGenerateKeyException
	{
		try( Connection conn = ConnectionFactory.getInstance().getConnection() ){
		    String sql = "insert into bank_accounts(user_id, account_type_id, balance) " +
					"values(?, ?, ?)";

		    String[] key = {"account_id"};
		    PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, userID);
			ps.setInt(2, typeID);
			ps.setDouble(3, balance);

			int updates = ps.executeUpdate();
			if(updates < 1)
				throw new UnableToGenerateKeyException();
			conn.commit();
		} catch (SQLException e) {
		    logger.error("SQLException has occurred in !", e);
		}
	}

	/**
	 * Read account by primary key.
	 *
	 * @param acc_id
	 * @return
	 */
	public static Account getAccount(Integer acc_id) throws NoSuchBankAccountException {
		Account acc = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from bank_accounts where account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, acc_id);
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) {
				acc = new Account( rs.getInt("account_id"), rs.getInt("user_id"),
						rs.getInt("account_type_id"), rs.getDouble("balance") );
			} else {
				throw new NoSuchBankAccountException();
			}
		} catch( SQLException e ) {
			logger.error("SQLException in getAccountsByID("+acc_id+")!", e);
		}
		return acc;
	}

	public static ArrayList<Account> getAccounts(Integer id){
		ArrayList<Account> as = new ArrayList<>();
		try( Connection conn = ConnectionFactory.getInstance().getConnection() ){
			String sql = "select * from bank_accounts where user_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				as.add(new Account(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getDouble(4)
				));
			}

		} catch (SQLException e) {
			logger.error("SQLException has occurred in getAccounts("+id+")!", e);
		}
		return as;
	}
	
	public static boolean withdrawBalance(Integer acc_id, Double amount) throws
		NonPositiveAmountException
	{
		if(amount < 0) throw new NonPositiveAmountException();
		try {
			changeBalance(acc_id, amount);
		} catch(SQLException e) {
			logger.error("SQLException occurred in withdrawBalance("+acc_id+", "+amount+")!", e);
		} catch(InsufficientFundsException e) {
			logger.error("Insufficient funds unable to withdraw amount:" + amount, e);
			return false;
		} catch(NoSuchBankAccountException e) {
			logger.error("NoSuchBankAccountException occured in withdrawBalance("+acc_id+", "+amount+")!", e);
		}
		return true;
	}
	
	public static boolean depositBalance(Integer acc_id, Double amount) throws
		NonPositiveAmountException
	{
		if(amount < 0) throw new NonPositiveAmountException();
		try {
			changeBalance(acc_id, -1*amount);
		} catch(SQLException e) {
			logger.error("SQLException occurred in depositBalance("+acc_id+", "+amount+")!", e);
		} catch(InsufficientFundsException e) {
			logger.error("How did this happen? Overflow?", e);
			return false;
		} catch(NoSuchBankAccountException e) {
			logger.error("NoSuchBankAccountException occured in depositBalance("+acc_id+", "+amount+")!", e);
			return false;
		}
		return true;
	}
	
	private static void changeBalance(Integer acc_id, Double amount) throws
		InsufficientFundsException,
		SQLException, NoSuchBankAccountException
	{
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call balance_tx(?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, acc_id);
			cs.setDouble(2, amount);
			
			int updates = cs.executeUpdate();
			
			if(updates < 1) throw new NoSuchBankAccountException();
			
			conn.commit();
		}
	}
	
}

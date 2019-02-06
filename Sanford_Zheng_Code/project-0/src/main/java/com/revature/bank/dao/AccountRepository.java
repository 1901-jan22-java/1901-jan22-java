package com.revature.bank.dao;

import com.jdbc.util.ConnectionFactory;
import com.revature.bank.exceptions.UnableToGenerateKeyException;
import com.revature.bank.pojos.Account;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

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
	public static Account getAccount(Integer acc_id) {
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
				throw new NoSuchElementException();
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
	
}

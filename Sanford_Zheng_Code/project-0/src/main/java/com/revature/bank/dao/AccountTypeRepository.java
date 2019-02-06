package com.revature.bank.dao;

import com.jdbc.util.ConnectionFactory;
import com.revature.bank.exceptions.DuplicateAccountTypeException;
import com.revature.bank.exceptions.NoSQLUpdatesException;
import com.revature.bank.pojos.AccountType;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountTypeRepository {

	protected static final Logger logger = Logger.getLogger(AccountRepository.class);

	// Need to add trigger for adding account id
	public static void addAccountType(String acc_type) throws
			DuplicateAccountTypeException,
			NoSQLUpdatesException
	{
		if(getAccountTypes().contains(acc_type)) throw new DuplicateAccountTypeException();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "insert into bank_account_types(account_type) values(?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, acc_type);

			if( ps.executeUpdate() < 1 ) {
				throw new NoSQLUpdatesException();
			}
		} catch ( SQLException e ) {
			logger.error("SQLException occurred when adding account type " + acc_type +"!", e);
		}
	}

	public static String getAccountTypeByID(int atid) {
		String at = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from bank_account_types where account_id = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, atid);
			ResultSet rs = ps.executeQuery();

			if( rs.next() ) {
				at = rs.getString("account_type");
			}
		} catch( SQLException e ) {
			logger.error("SQLException occurred when loading account types!", e);
		}
		return at;
	}

	public static ArrayList<AccountType> getAccountTypes() {
		ArrayList<AccountType> ats = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from bank_account_types";

			ResultSet rs = conn.createStatement().executeQuery(sql);

			while(rs.next()){
				ats.add( new AccountType(rs.getInt("account_id"), rs.getString("account_type")) );
			}
		} catch ( SQLException e ) {
			logger.error("SQLException occurred when getting account types!", e);
		}
		return ats;
	}

}

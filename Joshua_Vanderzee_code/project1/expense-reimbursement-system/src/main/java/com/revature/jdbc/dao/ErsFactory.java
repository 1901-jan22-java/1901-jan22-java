package com.revature.jdbc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.jdbc.ConnectionFactory;
import com.revature.jdbc.pojos.Ers;
import com.revature.jdbc.pojos.ErsReimbursement;
import com.revature.jdbc.pojos.ErsUser;

public final class ErsFactory {
	
	final static Logger logger = Logger.getLogger(ErsFactory.class);
	
	private ErsFactory() {}
	
	private static int loginAtempt = 0;
	private static String emailAlert = "";
	
	static int getLoginAtempt() {
		return loginAtempt;
	}

	static String getEmailAlert() {
		return emailAlert;
	}

	public static String hashString(String str) {
		String saltedhash = "n0w" + str.hashCode() + "$@1ted";
		String CompleteHash = saltedhash.hashCode() + "";
		return CompleteHash;
	}
	
	public static boolean CreateReimbursement(Ers ers) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call ERS_Create_REIMBURSEMENT(?, ?, ?, ?, ?, ?)}";
			CallableStatement ps = conn.prepareCall(sql);
			ErsReimbursement reimb = ers.getReimbursementByID(ers.lastReimbursement());
			ps.setLong(1, reimb.getReimb_amount());
			ps.setString(2, reimb.getReimbDescription());
			ps.setNull(3, java.sql.Types.BLOB);
			ps.setString(4, ers.getUser().getErsUsername());
			ps.setString(5, reimb.getReimb_Type());
			ps.registerOutParameter(6, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			System.out.println(ps.getInt(6));
			if (ps.getInt(6) == 1) {
				conn.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void findUserReimbursements(Ers ers)
	{
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select r.reimb_ID, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, " //1-5
			/*6-8*/	+ "u.USER_FIRST_NAME as authorfirst, u.USER_LAST_NAME as authorlast, u.USER_Email as authoremail, "
			/*9-11*/+ "a.USER_FIRST_NAME as resolverfirst, a.USER_LAST_NAME as resolverlast, a.USER_Email as resolveremail, "
		   /*12-13*/+ "rs.reimb_status as status, rt.reimb_type as type " +
						"from ers_users u " + 
						"inner join ers_reimbursement r on u.ers_users_id = r.REIMB_author " + 
						"inner join ERS_REIMBURSEMENT_STATUS rs on rs.reimb_status_id = r.reimb_status_id " + 
						"inner join ERS_REIMBURSEMENT_TYPE rt on rt.reimb_type_id = r.reimb_type_id " + 
						"left join ers_users a on a.ers_users_id = r.reimb_resolver " + 
						"where u.ers_username = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, ers.getUser().getErsUsername());
			ResultSet rs = statement.executeQuery();
			System.out.println("rs query");
			while(rs.next())
			{
				ers.AddReimbursement(rs.getLong(2), 
						new ErsUser(rs.getString(6), rs.getString(7), rs.getString(8)), 
						rs.getString(13));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimb_ID(rs.getLong(1));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimb_submitted(rs.getDate(3));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimbResolved(rs.getDate(4));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimbDescription(rs.getString(5));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimbResolver(new ErsUser(rs.getString(9), rs.getString(10), rs.getString(11)));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimb_Status(rs.getString(12));
			}
		} catch (SQLException e) {
			logger.error("Error with query");
			e.printStackTrace();
			//return new ArrayList<Account>();
		}
	}
	
	public static void getAllReimbursements(Ers ers) {
		if (ers.getUser() == null) {
			return;
		}
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select r.reimb_ID, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, " //1-4
			/*5-7*/	+ "u.USER_FIRST_NAME as authorfirst, u.USER_LAST_NAME as authorlast, u.USER_Email as authoremail, "
			/*8-10*/+ "a.USER_FIRST_NAME as resolverfirst, a.USER_LAST_NAME as resolverlast, a.USER_Email as resolveremail, "
		   /*11-12*/+ "rs.reimb_status as status, rt.reimb_type as type " +
						"from ers_users u " + 
						"inner join ers_reimbursement r on u.ers_users_id = r.REIMB_author " + 
						"inner join ERS_REIMBURSEMENT_STATUS rs on rs.reimb_status_id = r.reimb_status_id " + 
						"inner join ERS_REIMBURSEMENT_TYPE rt on rt.reimb_type_id = r.reimb_type_id " + 
						"left join ers_users a on a.ers_users_id = r.reimb_resolver ";
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
				ers.AddReimbursement(rs.getLong(2), 
						new ErsUser(rs.getString(6), rs.getString(7), rs.getString(8)), 
						rs.getString(13));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimb_ID(rs.getLong(1));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimb_submitted(rs.getDate(3));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimbResolved(rs.getDate(4));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimbDescription(rs.getString(5));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimbResolver(new ErsUser(rs.getString(9), rs.getString(10), rs.getString(11)));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimb_Status(rs.getString(12));
			}
		} catch (SQLException e) {
			logger.error("Error with query");
			e.printStackTrace();
			//return new ArrayList<Account>();
		}
	}
	
	public static void getAllPendingReimbursements(Ers ers) {
		if (ers.getUser() == null) {
			return;
		}
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select r.reimb_ID, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, " //1-4
			/*5-7*/	+ "u.USER_FIRST_NAME as authorfirst, u.USER_LAST_NAME as authorlast, u.USER_Email as authoremail, "
			/*8-10*/+ "a.USER_FIRST_NAME as resolverfirst, a.USER_LAST_NAME as resolverlast, a.USER_Email as resolveremail, "
		   /*11-12*/+ "rs.reimb_status as status, rt.reimb_type as type " +
						"from ers_users u " + 
						"inner join ers_reimbursement r on u.ers_users_id = r.REIMB_author " + 
						"inner join ERS_REIMBURSEMENT_STATUS rs on rs.reimb_status_id = r.reimb_status_id " + 
						"inner join ERS_REIMBURSEMENT_TYPE rt on rt.reimb_type_id = r.reimb_type_id " + 
						"left join ers_users a on a.ers_users_id = r.reimb_resolver " + 
						"where r.REIMB_status_ID = 1";
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
				ers.AddReimbursement(rs.getLong(2), 
						new ErsUser(rs.getString(6), rs.getString(7), rs.getString(8)), 
						rs.getString(13));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimb_ID(rs.getLong(1));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimb_submitted(rs.getDate(3));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimbResolved(rs.getDate(4));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimbDescription(rs.getString(5));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimbResolver(new ErsUser(rs.getString(9), rs.getString(10), rs.getString(11)));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimb_Status(rs.getString(12));
			}
		} catch (SQLException e) {
			logger.error("Error with query");
			e.printStackTrace();
			//return new ArrayList<Account>();
		}
	}
	
	public static void getAllResolvedReimbursements(Ers ers) {
		if (ers.getUser() == null) {
			return;
		}
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select r.reimb_ID, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, " //1-4
			/*5-7*/	+ "u.USER_FIRST_NAME as authorfirst, u.USER_LAST_NAME as authorlast, u.USER_Email as authoremail, "
			/*8-10*/+ "a.USER_FIRST_NAME as resolverfirst, a.USER_LAST_NAME as resolverlast, a.USER_Email as resolveremail, "
		   /*11-12*/+ "rs.reimb_status as status, rt.reimb_type as type " +
						"from ers_users u " + 
						"inner join ers_reimbursement r on u.ers_users_id = r.REIMB_author " + 
						"inner join ERS_REIMBURSEMENT_STATUS rs on rs.reimb_status_id = r.reimb_status_id " + 
						"inner join ERS_REIMBURSEMENT_TYPE rt on rt.reimb_type_id = r.reimb_type_id " + 
						"left join ers_users a on a.ers_users_id = r.reimb_resolver " + 
						"where r.REIMB_status_ID != 1";
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
				ers.AddReimbursement(rs.getLong(1), 
						new ErsUser(rs.getString(5), rs.getString(6), rs.getString(7)), 
						rs.getString(12));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimb_submitted(rs.getDate(2));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimbResolved(rs.getDate(3));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimbDescription(rs.getString(4));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimbResolver(new ErsUser(rs.getString(8), rs.getString(9), rs.getString(10)));
				ers.getReimbursementByID(ers.lastReimbursement()).setReimb_Status(rs.getString(11));
			}
			//return accounts;
		} catch (SQLException e) {
			logger.error("Error with query");
			e.printStackTrace();
			//return new ArrayList<Account>();
		}
	}
	
	public static ErsUser Login(String username, String password) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call Ers_login(?, ?, ?, ?)}";
			CallableStatement ps = conn.prepareCall(sql);
			ps.setString(1, username);
			ps.setString(2, hashString(password));
			ps.registerOutParameter(3, java.sql.Types.NUMERIC);
			ps.registerOutParameter(4, java.sql.Types.VARCHAR);
			ps.executeUpdate();
			long output = ps.getInt(3);
			switch ((int)output) {
				case 0:
					if (++loginAtempt >= 4) 
					{
						emailAlert = ps.getString(4);
						Thread.sleep(2000);
					}
					return null;
				case -1 :
			     	return null;
				default:
			     	return getUserInfo(output);
			}
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
     	return null;
	}
	
	private static ErsUser getUserInfo(long id) {
		if (id > 0) {
			try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
				String query = "select u.ERS_USERNAME, u.user_first_name, u.user_last_name, u.user_email, r.user_role from ers_users u " + 
						"inner join ERS_USER_ROLES r on u.user_role_id = r.ers_user_role_id " + 
						"where u.ers_users_id = ?";
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setLong(1, id);
				ResultSet rs = statement.executeQuery();
				if (rs.next())
				{
					ErsUser user = new ErsUser(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
					user.setUser_Role(rs.getString(5));
					return user;
				}
				//return accounts;
			} catch (SQLException e) {
				logger.error("Error with query");
				e.printStackTrace();
				//return new ArrayList<Account>();
			}
		}
		
		return null;
	}
	
	public static boolean CreateUser(Ers user) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call ErsCreateAccount(?, ?, ?, ?, ?, ?)}";
			CallableStatement ps = conn.prepareCall(sql);
			
			ps.setString(1, user.getUser().getErsUsername());
			ps.setString(2, hashString(user.getUser().getErsPassword()));
			ps.setString(3, user.getUser().getUserFirstName());
			ps.setString(4, user.getUser().getUserLastName());
			ps.setString(5, user.getUser().getUserEmail());
			ps.registerOutParameter(6, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			if (ps.getInt(6) == 1)
			{
				conn.commit();
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return false;
	}
}

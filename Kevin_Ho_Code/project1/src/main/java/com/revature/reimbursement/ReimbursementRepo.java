package com.revature.reimbursement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.user.User;
import com.revature.util.ConnectionFactory;

public class ReimbursementRepo {
	public List<Reimbursement> getReimbursements(User user)
	{
		List<Reimbursement> tmp = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";

			String[] keys = {"reimb_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ResultSet pk = ps.executeQuery();

			while(pk.next()) {
				Reimbursement temp = new Reimbursement(	pk.getInt("reimb_id"),
														pk.getDouble("reimb_amount"),
														pk.getDate("reimb_submitted"),
														pk.getDate("reimb_resolved"),
														pk.getString("reimb_description"),
														pk.getInt("reimb_author"),
														pk.getInt("reimb_resolver"),
														pk.getInt("reimb_status_id"),
														pk.getInt("reimb_type_id"));
				tmp.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	public List<Reimbursement> getAllReimbursements()
	{
		List<Reimbursement> tmp = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ers_reimbursement ORDER BY reimb_submitted DESC";

			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);

			while(rs.next()) {
				Reimbursement temp = new Reimbursement(	rs.getInt("reimb_id"),
														rs.getDouble("reimb_amount"),
														rs.getDate("reimb_submitted"),
														rs.getDate("reimb_resolved"),
														rs.getString("reimb_description"),
														rs.getInt("reimb_author"),
														rs.getInt("reimb_resolver"),
														rs.getInt("reimb_status_id"),
														rs.getInt("reimb_type_id"));
				tmp.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	public List<Reimbursement> getAllUnresolvedReimbursements()
	{
		List<Reimbursement> tmp = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_resolved IS NULL ORDER BY reimb_submitted DESC";

			String[] keys = {"reimb_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ResultSet pk = ps.executeQuery();

			while(pk.next()) {
				Reimbursement temp = new Reimbursement(	pk.getInt("reimb_id"),
														pk.getDouble("reimb_amount"),
														pk.getDate("reimb_submitted"),
														pk.getDate("reimb_resolved"),
														pk.getString("reimb_description"),
														pk.getInt("reimb_author"),
														pk.getInt("reimb_resolver"),
														pk.getInt("reimb_status_id"),
														pk.getInt("reimb_type_id"));
				tmp.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	public Reimbursement addReimb(int type, int user, double amount, String desc, int status, Date submitted) 
	{
		Reimbursement reimb = new Reimbursement();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ers_reimbursement(reimb_type_id, reimb_author, reimb_amount, "
													+ 	"reimb_description, reimb_status_id, reimb_submitted) "
													+ "	VALUES(?,?,?,?,?,?)";

			String[] keys = {"reimb_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ps.setInt(1, type);
			ps.setInt(2, user);
			ps.setDouble(3, amount);
			ps.setString(4, desc);
			ps.setInt(5, status);
			ps.setDate(6, submitted);
						
			
			int numRows = ps.executeUpdate();
			
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				reimb.setReimbId((pk.getInt(1)));
				reimb.setTypeId(type);
				reimb.setAmount(amount);
				reimb.setAuthor(user);
				reimb.setDescription(desc);
				reimb.setStatusId(status);
				reimb.setSubmitted(submitted);
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}
	
	public Reimbursement resolve(Reimbursement reimb)
	{
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call resolve(?,?,?,?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setInt(1, reimb.getReimbId());
			cs.setInt(2, reimb.getResolver());
			cs.setDate(3, reimb.getResolved());
			cs.setInt(4,  reimb.getStatusId());
			
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimb;
	}
}
package com.revature.reimbursement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
			ps.setInt(1, user.getUserId());
			ResultSet pk = ps.executeQuery();

			while(pk.next()) {
				Reimbursement temp = new Reimbursement(	pk.getInt("reimb_id"),
														pk.getDouble("reimb_amount"),
														pk.getTimestamp("reimb_submitted"),
														pk.getTimestamp("reimb_resolved"),
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
														rs.getTimestamp("reimb_submitted"),
														rs.getTimestamp("reimb_resolved"),
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
														pk.getTimestamp("reimb_submitted"),
														pk.getTimestamp("reimb_resolved"),
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
	
	public Reimbursement addReimb(Reimbursement reimb)
	{
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) 
		{
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ers_reimbursement(reimb_type_id, reimb_author, reimb_amount, "
													+ 	"reimb_description, reimb_status_id, reimb_submitted) "
													+ "	VALUES(?,?,?,?,?,?)";

			String[] keys = {"reimb_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ps.setInt(1, reimb.getTypeId());
			ps.setInt(2, reimb.getAuthor());
			ps.setDouble(3, reimb.getAmount());
			ps.setString(4, reimb.getDescription());
			ps.setInt(5, reimb.getStatusId());
			ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			
			ps.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}
	
	public Reimbursement resolve(Reimbursement reimb, int statusId)
	{
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "{call resolve(?,?,?,?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setInt(1, reimb.getReimbId());
			cs.setInt(2, reimb.getAuthor());
			cs.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			cs.setInt(4, statusId);
			
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimb;
	}	
}
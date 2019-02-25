package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.TimeZone;

import com.jdbc.pojos.Reimbursement;
import com.jdbc.pojos.Users;
import com.jdbc.util.ConnectionFactory;

public class ReimbursmentRepository {

	public Reimbursement addReimbursement(Reimbursement reimb) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description,"
					+ " reimb_author, reimb_status_id, reimb_type_id)"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			String[] key = {"reimb_id"};
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setDouble(1, reimb.getAmount());
			ps.setTimestamp(2, reimb.getSubmitted(), Calendar.getInstance(TimeZone.getTimeZone("UTC")));
			ps.setString(3, reimb.getDescription());
			ps.setInt(4, reimb.getAuthor());
			ps.setInt(5, reimb.getStatusId());
			ps.setInt(6, reimb.getTypeId());
			
//			int numRowsUpdated = ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			if(pk.next()) {
				reimb.setReimbId(pk.getInt(1));
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}
}

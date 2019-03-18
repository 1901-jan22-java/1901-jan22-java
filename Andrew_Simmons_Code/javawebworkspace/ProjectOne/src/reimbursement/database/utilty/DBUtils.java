package reimbursement.database.utilty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import reimbursement.main.dataFactory.Reimbursement;
import reimbursement.main.dataFactory.UserAccount;

public class DBUtils {
	
	
	 
    public static UserAccount findUser(Connection conn, //
            String userName, String password) throws SQLException {
 
//    	String sql =  "Select ERS_USERNAME, ERS_PASSWORD, Gender from ERS_USERS WHERE ERS_USERNAME = ? and ERS_PASSWORD = ?";
    	
    	String sql =  "Select * from ERS_USERS WHERE ERS_USERNAME = ? and ERS_PASSWORD = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
        	
            String gender = rs.getString("Gender");
            String email = rs.getString("USER_EMAIL");
            UserAccount user = new UserAccount();
            user.setUsername(userName);
            user.setPassword(password);
            user.setGender(gender);
            user.setEmail(email);
            return user;
        }
        return null;
    }
 
    public static UserAccount findUser(Connection conn, String userName) throws SQLException {
 
    	
    	//String sql =  "Select ERS_USERNAME, ERS_PASSWORD, Gender from ERS_USERS WHERE ERS_USERNAME = ?";
    	String sql =  "Select * from ERS_USERS WHERE ERS_USERNAME = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("Password");
            String gender = rs.getString("Gender");
            String email = rs.getString("USER_EMAIL");
            UserAccount user = new UserAccount();
            user.setUsername(userName);
            user.setPassword(password);
            user.setGender(gender);
            user.setEmail(email);
            return user;
        }
        return null;
    }
    
    
    
    public static List<Reimbursement> queryReimbursement(Connection conn) throws SQLException {
    	String sql = "SELETE * FROM ERS_REIBURSEMENT";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Reimbursement> list = new ArrayList<Reimbursement>();
        while (rs.next()) {
        	
        	 int author_id = rs.getInt(" REIMB_AUTHOR");
          	 Integer amount = rs.getInt("REIMB_AMOUNT");	
             String date_submitted = rs.getString("REIMB_SUBMITTED");
             String date_resolved = rs.getString("REIMB_RESOLVED");
             String description = rs.getString("REIMB_DESCRIPTION");
            Reimbursement reimbursement = new Reimbursement();
            reimbursement.setAuthor_id(author_id);
            reimbursement.setAmount(amount);
            reimbursement.setDate_submitted(date_submitted);
            reimbursement.setDate_resolved(date_resolved);
            reimbursement.setDescription(description);
            list.add(reimbursement);
        }
        return list;
    }
 
    public static Reimbursement findReimbursement(Connection conn, String author_id) throws SQLException {
    	String sql = "SELETE * FROM ERS_REIBURSEMENT WHERE REIMB_AUTHOR = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, author_id);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
       	 Integer amount = rs.getInt("REIMB_AMOUNT");	
          String date_submitted = rs.getString("REIMB_SUBMITTED");
          String date_resolved = rs.getString("REIMB_RESOLVED");
          String description = rs.getString("REIMB_DESCRIPTION");
          Reimbursement reimbursement = new Reimbursement(amount, date_submitted , date_resolved, description);
            return reimbursement;
        }
        return null;
    }
 

//    
//    
//    public static Reimbursement findStatus(Connection conn, String userName)throws SQLException{
//    	
//    	String sql = "SELECT * from ERS_REIMBURSEMENT" + 
//		"JOIN" + 
//		"ERS_USERS ON ERS_REIMBURSEMENT.REIMB_AUTHOR = ERS_USERS.ERS_USERS_ID" + 
//		"WHERE ERS_USERS.ERS_USERNAME = ?";
//    	
//    	PreparedStatement pstm = conn.prepareStatement(sql);
//    	pstm.setString(1, userName);
//    	ResultSet rs = pstm.executeQuery();
//    	
//    	
//    	
//    	while(rs.next()) {
//    	 Integer amount = rs.getInt("REIMB_AMOUNT");	
//         String date_submitted = rs.getString("REIMB_SUBMITTED");
//         String date_resolved = rs.getString("REIMB_RESOLVED");
//         String description = rs.getString("REIMB_DESCRIPTION");
//         Reimbursement reimbursement = new Reimbursement(amount, date_submitted , date_resolved, description);
//         return reimbursement;
//    		
//    	}
//    	
//
//    	
//    	return null;
//    	
//    }
    
    

 
}




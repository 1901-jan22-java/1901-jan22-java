package associate_project.Associate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;







public class AssociateRepository {

	final static Logger logger = Logger.getLogger(AssociateRepository.class);
	public List<Associate> findAll(){
		List<Associate> peeps = new ArrayList<Associate>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			
			String query = "select * from Associates";
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				//can access data in cells via column index OR name
				Associate temp = new 
		Associate(rs.getInt(1), rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("pwrd"),rs.getInt(6));
				peeps.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return peeps;
	}
	
	public Associate getAssociateInfo(String pwrd){
		Associate r=null;
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="select * from associates where pwrd = ?";
			PreparedStatement ps= conn.prepareStatement(query);
			ps.setString(1,pwrd);
			ResultSet info=ps.executeQuery();
			if(info.next()){
				r=new Associate();
				r.setId(info.getInt(1));
				r.setFirstName(info.getString(2));
				r.setLastName(info.getString(3));
				r.setEmail(info.getString(4));
				r.setPassword(pwrd);
				r.setGrade(info.getInt(6));
				
				
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return r;
	}
	public void getAssociateInfoPrint(String pwrd){
		Associate r=null;
		try(Connection conn=ConnectionFactory.getInstance().getConnection()){
			String query="select * from associates where pwrd = ?";
			PreparedStatement ps= conn.prepareStatement(query);
			ps.setString(1,pwrd);
			ResultSet info=ps.executeQuery();
			if(info.next()){
				r=new Associate();
				r.setId(info.getInt(1));
				r.setFirstName(info.getString(2));
				r.setLastName(info.getString(3));
				r.setEmail(info.getString(4));
				r.setPassword(pwrd);
				r.setGrade(info.getInt(6));
				
				
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		System.out.println(r.getFirstName());
		System.out.println(r.getLastName());
		System.out.println(r.getEmail());
		
	}
	public void update1(Associate r) { //1, "something random"
		//param passed in will contain id of entity to be 
		//changed WITH the new values to change it to
		

		
		   try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
	            conn.setAutoCommit(false);
	            String sql = "UPDATE Associates SET firstname = ? WHERE a_id = ? ";
	            
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1,r.getFirstName());
	            ps.setInt(2,r.getId());
	            
	             ps.executeUpdate();
	            
	            conn.commit();
	            
	        }
		   
		   catch (SQLException e) {
	            e.printStackTrace();
	        }
		  
		  
	        
	        
	}
	public void update2(Associate r) { //1, "something random"
		//param passed in will contain id of entity to be 
		//changed WITH the new values to change it to
		

		
		   try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
	            conn.setAutoCommit(false);
	            String sql = "UPDATE Associates SET lastname = ? WHERE a_id = ? ";
	            
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1,r.getLastName());
	            ps.setInt(2,r.getId());
	            
	             ps.executeUpdate();
	            
	            conn.commit();
	            
	        }
		   
		   catch (SQLException e) {
	            e.printStackTrace();
	        }
		  
		  
	        
	        
	}
	public void update3(Associate r) { //1, "something random"
		//param passed in will contain id of entity to be 
		//changed WITH the new values to change it to
		

		
		   try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
	            conn.setAutoCommit(false);
	            String sql = "UPDATE Associates SET email = ? WHERE a_id = ? ";
	            
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1,r.getEmail());
	            ps.setInt(2,r.getId());
	            
	             ps.executeUpdate();
	            
	            conn.commit();
	            
	        }
		   
		   catch (SQLException e) {
	            e.printStackTrace();
	        }
		  
		  
	        
	        
	}
	public void update4(Associate r) { //1, "something random"
		//param passed in will contain id of entity to be 
		//changed WITH the new values to change it to
		

		
		   try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
	            conn.setAutoCommit(false);
	            String sql = "UPDATE Associates SET pwrd = ? WHERE a_id = ? ";
	            
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1,r.getPassword());
	            ps.setInt(2,r.getId());
	            
	             ps.executeUpdate();
	            
	            conn.commit();
	            
	        }
		   
		   catch (SQLException e) {
	            e.printStackTrace();
	        }
		  
		  
	        
	        
	}
	
}

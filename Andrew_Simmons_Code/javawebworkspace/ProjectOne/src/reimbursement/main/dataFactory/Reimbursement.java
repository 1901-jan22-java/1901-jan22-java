package reimbursement.main.dataFactory;

/**
 * JavaBean for Reimbursement- contains all reimbursement properties
 * @author Rikki
 *
 */
import java.util.Date;

public class Reimbursement {

	
	private int id;
	private int amount;
	private String date_submitted;
	private String date_resolved;
	private String description;
	private int author_id;
	private int resolver_id;
	private int status_id;
	private int type_id;
	
	/**
	 * @return the id
	 */
	
	
	
	public Reimbursement(){}
	
	
	public Reimbursement(int amount, String date_submitted, String date_resolved, String description) {
		super();
		this.amount = amount;
		this.date_submitted = date_submitted;
		this.date_resolved = date_resolved;
		this.description = description;
	}


	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}



	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}



	/**
	 * @return the date_submitted
	 */
	public String getDate_submitted() {
		return date_submitted;
	}



	/**
	 * @param date_submitted the date_submitted to set
	 */
	public void setDate_submitted(String date_submitted) {
		this.date_submitted = date_submitted;
	}



	/**
	 * @return the date_resolved
	 */
	public String getDate_resolved() {
		return date_resolved;
	}



	/**
	 * @param date_resolved the date_resolved to set
	 */
	public void setDate_resolved(String date_resolved) {
		this.date_resolved = date_resolved;
	}



	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}



	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



	/**
	 * @return the author_id
	 */
	public int getAuthor_id() {
		return author_id;
	}



	/**
	 * @param author_id the author_id to set
	 */
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}



	/**
	 * @return the resolver_id
	 */
	public int getResolver_id() {
		return resolver_id;
	}



	/**
	 * @param resolver_id the resolver_id to set
	 */
	public void setResolver_id(int resolver_id) {
		this.resolver_id = resolver_id;
	}



	/**
	 * @return the status_id
	 */
	public int getStatus_id() {
		return status_id;
	}



	/**
	 * @param status_id the status_id to set
	 */
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}



	/**
	 * @return the type_id
	 */
	public int getType_id() {
		return type_id;
	}



	/**
	 * @param type_id the type_id to set
	 */
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}



	




	
	
	

	
}

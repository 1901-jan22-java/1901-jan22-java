package pojos;

public class Account {

	private int id;
	private int userId;
	private double balance;
	private String type;
	
	
	
	
	public Account() {}
	
	
	
	/**
	 * @return the id
	 */
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
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}



	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}



	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}



	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}



	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}



	public Account(int userId, double balance, String type) {
		super();
		this.userId = userId;
		this.balance = balance;
		this.type = type;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [id=" + id + ", userId=" + userId + ", balance=" + balance + ", type=" + type + "]";
	}
	
	
	
	
}

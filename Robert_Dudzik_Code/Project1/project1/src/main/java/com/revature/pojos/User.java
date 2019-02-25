package com.revature.pojos;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserRepository;

public class User 
{
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int roleId;
    private List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
    UserRepository uResp = new UserRepository();


    public User() { }
    public User(String username, String password) { this.username = username; this.password = password; }

    public int getId(){ return id; }

    public void setId(int id) { this.id = id; }
    
    public String getUsername(){ return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() {  return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getRoleId() { return roleId; }

    public void setRoleId(int roleId) { this.roleId = roleId; }
    
    public List<Reimbursement> getReimbursements(){ return reimbursements; }
    
    public void addReimbursement(Reimbursement r) { reimbursements.add(r); }

    public User checkUser(String username, String password)
    {
        User temp = new User();
        temp = uResp.logInUser(username, password);
        return temp;
    }

    public User getAllUserReimbursements()
    {
        User temp = this;
        temp = uResp.getReimbursements(temp);
        return temp;
    }

    public User getAllReimbursements()
    {
        User temp = this;
        temp = uResp.getAllReimbursements(temp);
        return temp;
    }

    public boolean findSpecificReim(int reimId)
    {
        for(int i = 0; i < reimbursements.size(); i++)
        {
            if(reimbursements.get(i).getId() == reimId)
                return true;
        }
        return false;
    }

    public void updateSpecificReimbursement(Reimbursement r)
    {
        for(int i = 0; i < reimbursements.size(); i++)
        {
            if(reimbursements.get(i).getId() == r.getId())
            {
                reimbursements.remove(i);
                reimbursements.add(r);
            }
        }
    }

    public Reimbursement getSpecificReim(int index)
    {
        return reimbursements.get(index);
    }

    public Reimbursement getSpecificReim(Reimbursement r)
    {
        for(int i = 0; i < reimbursements.size(); i++)
        {
            if(reimbursements.get(i).getId() == r.getId())
                return reimbursements.get(i);
        }
        return null;
    }
}

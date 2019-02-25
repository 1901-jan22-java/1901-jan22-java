package com.revature.pojos;

import com.revature.dao.ReimbursementRepository;

public class Reimbursement 
{
    private int id;
    private double amount;
    private String timeSubmitted;
    private String timeResolved;
    private String description;
    private String author;
    private String resolver;
    private String status;
    private String type;
    private int authorId;
    private int resolverId;
    private int statusId;
    private int typeId;

    public Reimbursement() { }

    public String getAuthor() { return author; }

    public String getResolver() { return resolver; }

    public String getStatus() { return status; }

    public String getType() { return type; }

    public void setAuthor(String author) { this.author = author; }

    public void setResolver(String resolver) { this.resolver = resolver; }

    public void setStatus(String status) { this.status = status; }

    public void setType(String type) { this.type = type; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public double getAmount() { return amount; }

    public void setAmount(double amount) { this.amount = amount; }

    public String getTimeSubmitted() { return timeSubmitted; }

    public void setTimeSubmitted(String timeSubmitted) { this.timeSubmitted = timeSubmitted; }

    public String getTimeResolved() { return timeResolved; }

    public void setTimeResolved(String timeResolved) { this.timeResolved = timeResolved; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getAuthorId() { return authorId; }

    public void setAuthorId(int authorId) { this.authorId = authorId; }

    public int getResolverId() { return resolverId; }

    public void setResolverId(int resolverId) { this.resolverId = resolverId; }

    public int getStatusId() { return statusId; }

    public void setStatusId(int statusId) { this.statusId = statusId; }

    public int getTypeId() { return typeId; }

    public void setTypeId(int typeId) { this.typeId = typeId; }
    
    public Reimbursement addReimbursementToDB()
    {
        ReimbursementRepository r = new ReimbursementRepository();
        Reimbursement results = r.addReimbursement(this);
        return results;
    }

    public Reimbursement updateReimbursement()
    {
        ReimbursementRepository r = new ReimbursementRepository();
        System.out.println(id);
        return r.updatReimbursement(this);
    }
}

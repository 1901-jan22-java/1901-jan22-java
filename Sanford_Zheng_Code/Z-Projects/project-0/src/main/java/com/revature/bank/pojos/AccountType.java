package com.revature.bank.pojos;

public class AccountType {
    private Integer typeID;
    private String type;

    public AccountType(Integer typeID, String type) {
        this.typeID = typeID;
        this.type = type;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "typeID=" + typeID +
                ", type='" + type + '\'' +
                '}';
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

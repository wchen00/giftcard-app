package com.bhn.adhawk.beans;

/**
 * Created by wchen00 on 4/25/16.
 */
public class Request {
    private String phonenumber;
    private String amount;
    private String friendPhonenumber;
    private String message;
    private String password;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFriendPhonenumber() {
        return friendPhonenumber;
    }

    public void setFriendPhonenumber(String friendPhonenumber) {
        this.friendPhonenumber = friendPhonenumber;
    }
}

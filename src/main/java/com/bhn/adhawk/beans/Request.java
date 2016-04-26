package com.bhn.adhawk.beans;

/**
 * Created by wchen00 on 4/25/16.
 */
public class Request {
    private String phonenumber;
    private String amount;
    private String message;

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
}

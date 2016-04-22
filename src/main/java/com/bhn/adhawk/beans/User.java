package com.bhn.adhawk.beans;

/**
 * Created by dnaga00 on 4/21/16.
 */
public class User {

    public Integer id;
    public String userName;
    public String password;
    public String phoneNumber;
    public String creditCardNumber;
    public Integer cvv;
    public String month;
    public String year;
    public Integer bhnCredit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getBhnCredit() {
        return bhnCredit;
    }

    public void setBhnCredit(Integer bhnCredit) {
        this.bhnCredit = bhnCredit;
    }
}

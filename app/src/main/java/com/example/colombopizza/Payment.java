package com.example.colombopizza; // Package

public class Payment { // Payment Class
    // private attributes

    private int PayId;
    private String cardNumber;
    private String cholderName;
    private String cvvNumber;
    private String expDate;

    public Payment() { // Default Constructor

        PayId = 0;
        cardNumber = "";
        cholderName = "";
        cvvNumber = "";
        expDate = "";
    }

    public Payment( int PayId, String cardNumber, String cholderName, String cvvNumber, String expDate) {

        // overload constructor
        this.PayId = PayId;
        this.cardNumber = cardNumber;
        this.cholderName =cholderName;
        this.cvvNumber = cvvNumber;
        this.expDate = expDate;
    }

    public int getPayId() { // Get Method

        return  PayId;
    }
    public void setPayId(int PayId) { // Set Method

        this.PayId = PayId;
    }

    public String getCardNumber() {

        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {

        this.cardNumber = cardNumber;
    }

    public String getCholderName() {

        return  cholderName;
    }

    public void setCholderName(String cholderName) {

        this.cholderName = cholderName;
    }

    public String getCvvNumber() {

        return  cvvNumber;
    }
    public void setCvvNumber (String cvvNumber) {

        this.cvvNumber = cvvNumber;
    }

    public String getExpDate() {

        return  expDate;
    }

    public void setExpDate(String expDate) {

        this.expDate = expDate;
    }



}

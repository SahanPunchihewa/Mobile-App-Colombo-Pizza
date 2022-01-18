package com.example.colombopizza; // Package

public class Order { // Order Class

    // Private Attributes

    private int orderId;
    private String pName;
    private String pType;
    private String pQuantity;
    private String pPrice;
    private String tPrice;

    public Order() { // Default Constructor

        orderId = 0;
        pName = "";
        pType = "";
        pQuantity = "";
        pPrice = "";
        tPrice = "";
    }

    public Order(int orderId, String pName, String pType, String pQuantity, String pPrice, String tPrice) {

        // Overload Constructor

        this.orderId = orderId;
        this.pName = pName;
        this.pType =pType;
        this.pQuantity =pQuantity;
        this.pPrice = pPrice;
        this.tPrice = tPrice;
    }

    public int getOrderId() { // Get Method

        return  orderId;
    }

    public void setOrderId(int orderId) { // Set Method

        this.orderId = orderId;
    }

    public String getpName() {

        return  pName;
    }

    public void setpName(String pName) {

            this.pName = pName;
    }

    public String getpType() {

        return  pType;
    }

    public void setpType(String pType) {

        this.pType = pType;
    }

    public String getpQuantity() {

        return pQuantity;
    }

    public void setpQuantity(String pQuantity) {

        this.pQuantity = pQuantity;
    }

    public String getpPrice() {

        return  pPrice;
    }

    public void setpPrice(String pPrice) {

        this.pPrice = pPrice;
    }

    public String gettPrice () {

        return  tPrice;
    }

    public void settPrice(String tPrice) {

        this.tPrice = tPrice;
    }



}

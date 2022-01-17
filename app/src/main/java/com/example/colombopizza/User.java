package com.example.colombopizza;

public class User {

    private String userid;
    private String username;
    private String address;
    private String phone;
    private String password;


    public User(String userid, String username, String address, String phone, String password) {
        this.userid = userid;
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


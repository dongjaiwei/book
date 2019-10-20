package com.dongjiawei.tree_hold.entity;




import java.io.Serializable;


public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;
    private String token;
    private String power;
    private int id;



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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", power='" + power + '\'' +
                ", id=" + id +
                '}';
    }
}

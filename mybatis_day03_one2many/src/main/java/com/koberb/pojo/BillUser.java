package com.koberb.pojo;

public class BillUser extends Bill {
    private String username;
    private String usertype;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return super.toString()+"BillUser{" +
                "username='" + username + '\'' +
                ", usertype='" + usertype + '\'' +
                '}';
    }
}

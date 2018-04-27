package com.example.rohini.footware;

/**
 * Created by Rohini on 20-04-2018.
 */

public class User {

    public String id;
    public String userName;
    public String userAddress;
    public String userMobile;
    public String email;
    public String password;

    public User(String id, String userName, String userAddress, String userMobile, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.userAddress=userAddress;
        this.userMobile=userMobile;
        this.email = email;
        this.password = password;
    }
}

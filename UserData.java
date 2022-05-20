package com.example.capstoneapp;

public class UserData {
    private String userName;
    private String userId;
    private String userPassword;
    private String userGender;
    private String userEmail;
    private String userBrith;

    //생성자
    public UserData(String userName, String userId, String userPassword, String userGender, String userEmail) {
        this.userName = userName;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userGender = userGender;
        this.userEmail = userEmail;
    }
    //Getter & Setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserBrith() { return userBrith; }

    public void setUserBrith(String userBrith) { this.userBrith = userBrith; }
}

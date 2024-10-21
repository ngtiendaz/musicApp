package com.mycompany.musicapp.model;

public class Model_User {

    private int UserID;
    private String Email;
    private String Pass;
    private String ImagePathUser;
    private String NameUser;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Model_User(int UserID, String Email, String Pass, String ImagePathUser, String NameUser, String role) {
        this.UserID = UserID;
        this.Email = Email;
        this.Pass = Pass;
        this.ImagePathUser = ImagePathUser;
        this.NameUser = NameUser;
        this.role = role;
    }

    public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String NameUser) {
        this.NameUser = NameUser;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getImagePathUser() {
        return ImagePathUser;
    }

    public void setImagePathUser(String ImagePathUser) {
        this.ImagePathUser = ImagePathUser;
    }

}

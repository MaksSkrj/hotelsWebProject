package ua.nure.skrypnyk.model;

import java.util.Date;

public class User extends Entity<Integer>{
    private String login;
    private String name;
    private String lastName;
    private Date DOB;
    private String sex;
    private int preferencesId;
    private int bookingId;
    private String password;

    public User(){

    }

    public User(String login,String name, String lastName, Date DOB, String sex, int preferencesId, int bookingId, String password) {
        this.login = login;
        this.name = name;
        this.lastName = lastName;
        this.DOB = DOB;
        this.sex = sex;
        this.preferencesId = preferencesId;
        this.bookingId = bookingId;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getPreferencesId() {
        return preferencesId;
    }

    public void setPreferencesId(int preferencesId) {
        this.preferencesId = preferencesId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", sex='" + sex + '\'' +
                ", preferencesId=" + preferencesId +
                ", bookingId=" + bookingId +
                '}';
    }
}

package com.example.gym_project.Model;

public class members {
    private int id ;
    private String name ;
    private String phone ;
    private String DateOfJoining ;
    private String ExpirationDate ;

    public members() {
    }
    public members(String name, String dateOfJoining, String expirationDate) {

        this.name = name;

        DateOfJoining = dateOfJoining;
        ExpirationDate = expirationDate;
    }

    public members(String name, String phone, String dateOfJoining, String expirationDate) {

        this.name = name;
        this.phone = phone;
        DateOfJoining = dateOfJoining;
        ExpirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfJoining() {
        return DateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        DateOfJoining = dateOfJoining;
    }

    public String getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        ExpirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "members {" +
                "id=" + id +
                "name=" + name +
                ", phone='" + phone + '\'' +
                ", DateOfJoining='" + DateOfJoining + '\'' +
                ", ExpirationDate='" + ExpirationDate + '\'' +
                '}';
    }
}

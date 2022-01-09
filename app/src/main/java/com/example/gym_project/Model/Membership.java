package com.example.gym_project.Model;

public class Membership {
    private int id ;
    private String Mname ;
    private String Mlength ;
    private String Price ;

    public Membership() {
    }

    public Membership( String mname, String mlength, String price) {

        Mname = mname;
        Mlength = mlength;
        Price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public String getMlength() {
        return Mlength;
    }

    public void setMlength(String mlength) {
        Mlength = mlength;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", Mname='" + Mname + '\'' +
                ", Mlength='" + Mlength + '\'' +
                ", Price='" + Price + '\'' +
                '}';
    }
}

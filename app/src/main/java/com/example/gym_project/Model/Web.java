package com.example.gym_project.Model;

public class Web {
    private String name ;


    public Web() {
    }

    public Web(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Web{" +
                "name='" + name + '\'' +
                '}';
    }
}

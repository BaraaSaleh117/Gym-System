package com.example.gym_project.Model;

public class workouts {
    private int id ;
    private String name ;
    private String weeklySchedule ;

    public workouts() {
    }


    public workouts(String name, String weeklySchedule) {

        this.name = name;
        this.weeklySchedule = weeklySchedule;
    }
    public workouts(String name) {

        this.name = name;

    }
    public workouts(String weeklySchedule,boolean flag) {

        this.weeklySchedule = weeklySchedule;

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

    public String getWeeklySchedule() {
        return weeklySchedule;
    }

    public void setWeeklySchedule(String weeklySchedule) {
        this.weeklySchedule = weeklySchedule;
    }
}

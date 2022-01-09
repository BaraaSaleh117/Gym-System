package com.example.gym_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EmployeePart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_part);
    }

    public void Manage_Members(View view) {
        Intent intent  = new Intent(this, MainActivity.class);

        startActivity(intent);
    }

    public void Manage_MemberShip(View view) {
        Intent intent  = new Intent(this, ManageMembership.class);

        startActivity(intent);
    }

    public void Manage_workouts(View view) {
    }

    public void Manage_nutritionP(View view) {
    }
}
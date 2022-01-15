package com.example.gym_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class _GymActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._gym);

    }


    public void member(View view) {
        Intent intent = new Intent(_GymActivity.this,_MemberShipChooser.class);
        startActivity(intent);
    }

    public void employee(View view) {
        Intent intent = new Intent(_GymActivity.this,EmployeePart.class);
        startActivity(intent);
    }
}
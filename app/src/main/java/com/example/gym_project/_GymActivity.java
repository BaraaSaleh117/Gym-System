package com.example.gym_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class _GymActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._gym);
        findViewById(R.id.port_btn).setVisibility(View.GONE);


    }


    public void member(View view) {
        Intent intent = new Intent(_GymActivity.this,_MemberShipChooser.class);
        startActivity(intent);
    }

    public void employee(View view) {
        Intent intent = new Intent(_GymActivity.this,EmployeePart.class);
        startActivity(intent);
    }

    public void Landscape(View view) {
        findViewById(R.id.port_btn).setVisibility(View.VISIBLE);
        findViewById(R.id.land_btn).setVisibility(View.GONE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


    }

    public void Portrait(View view) {
        findViewById(R.id.port_btn).setVisibility(View.GONE);
        findViewById(R.id.land_btn).setVisibility(View.VISIBLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }
}
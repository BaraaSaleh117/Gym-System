package com.example.gym_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class membersDetails extends AppCompatActivity {
    private TextView nameE, phoneE, DateOfJoiningE,ExpirationDateE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membersdetails);
        nameE = findViewById(R.id.name);
        phoneE = findViewById(R.id.phone);
        DateOfJoiningE = findViewById(R.id.Dj);
        ExpirationDateE = findViewById(R.id.ED);

        Intent intent = this.getIntent();
        if(intent!=null){
            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            String DateOfJoining = intent.getStringExtra("DateOfJoining");
            String ExpirationDate = intent.getStringExtra("ExpirationDate");

            nameE.setText(name);
            phoneE.setText(phone);
            DateOfJoiningE.setText(DateOfJoining);
            ExpirationDateE.setText(ExpirationDate);

        }
    }

}
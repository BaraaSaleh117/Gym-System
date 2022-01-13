package com.example.gym_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class nutritiondetails extends AppCompatActivity {
    private TextView name, desc;
    private ImageView image ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritiondetails);
        image = findViewById(R.id.imagee);
        name = findViewById(R.id.textView4);
        desc = findViewById(R.id.textView6);


        Intent intent = this.getIntent();
        if(intent!=null){
            String imagee = intent.getStringExtra("image");
            String namee = intent.getStringExtra("name");
            String descc = intent.getStringExtra("desc");


            Drawable dr = ContextCompat.getDrawable(nutritiondetails.this ,Integer.parseInt(imagee));
            image.setImageDrawable(dr);
            name.setText(namee);
            desc.setText(descc);


        }
    }



    }

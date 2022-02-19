package com.example.gym_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gym_project.Model.nutritions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Nutrition extends AppCompatActivity {
    String[] captions;

    int[] ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrition);

        RecyclerView recycler = findViewById(R.id.recycler);

        captions = new String[nutritions.nutritions.length];
        ids = new int[nutritions.nutritions.length];

        for(int i = 0; i<captions.length;i++){
            captions[i] = nutritions.nutritions[i].getName();
          //   desc[i] =nutritions.nutritions[i].getDescription();
            ids[i] = nutritions.nutritions[i].getImage();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        NutritionsAdapter adapter = new NutritionsAdapter(captions, ids);
        recycler.setAdapter(adapter);
        recycler.setClickable(true);
        recycler.setOnClickListener(
                new AdapterView.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }


                });


    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
package com.example.gym_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gym_project.Model.Membership;
import com.example.gym_project.Model.nutritions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class _Nutritios_chooser extends AppCompatActivity {

    private final  String items []= {" ","High-protein foods","Low Carb diet","The Mediterranean diet","The Ketogenic Diet"
            ,"Zone diet"};
    Spinner spinner;



    TextView textView ;
    JSONObject obj = null;
    public static final String PREFS = "Pref";
    public static final String TEX = "t";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._nutritios_chooser);
        spinner = findViewById(R.id.spinner2);
        textView = (TextView) findViewById(R.id.textView20);

        loadItems();

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


    private void loadItems() {


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(_Nutritios_chooser.this, android.R.layout.simple_spinner_dropdown_item,items );
                                spinner.setAdapter(adapter);
                                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        textView.setText(parent.getItemAtPosition(position).toString());
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

            }


        });
        t1.start();

    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(TEX ,textView.getText().toString());
        editor.apply();

        Toast.makeText(this, "DATA SAVED",Toast.LENGTH_SHORT).show();

    }



    public void button4(View view) {
        saveData();
        Intent intent = new Intent(_Nutritios_chooser.this,_Members_Profile.class);
        startActivity(intent);
    }
}
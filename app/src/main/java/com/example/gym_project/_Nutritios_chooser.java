package com.example.gym_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    ArrayList<String> mem;
    private static final String BASE_URL = "http://10.0.2.2/Gym/get_items.php";
    private RequestQueue queue;
    TextView textView ,textView2;
    JSONObject obj = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._nutritios_chooser);
        spinner = findViewById(R.id.spinner2);
        textView = (TextView) findViewById(R.id.textView10);
        textView2 = (TextView) findViewById(R.id.textView12);
        queue = Volley.newRequestQueue(this);
        loadItems();

    }


    private void loadItems() {


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(_Nutritios_chooser.this, android.R.layout.simple_spinner_dropdown_item,items );
                                spinner.setAdapter(adapter);

            }


        });
        t1.start();

    }


    public void button4(View view) {
//        Intent intent = new Intent(_Nutritios_chooser.this,Workout_member.class);
//        startActivity(intent);
    }
}
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
import com.example.gym_project.Model.workouts;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Workout_member extends AppCompatActivity {

    private List<String> items = new ArrayList<>();
    private List<String> weekscagual = new ArrayList<>();
    Spinner spinner ;
    ArrayList<String> mem;
    private static  final String BASE_URL = "http://10.0.2.2/Gym/get_workouts.php";
    private RequestQueue queue;
    TextView textView;
    JSONObject obj=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._workout_member);
        spinner = findViewById(R.id.spinner2);
        textView = (TextView)findViewById(R.id.textView10) ;
        queue = Volley.newRequestQueue(this);
        loadItems();

    }


    private void loadItems() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {


                                try {

                                    JSONArray array = new JSONArray(response);
                                    for (int i = 0; i < array.length(); i++) {

                                        JSONObject object = array.getJSONObject(i);

                                        String name = object.getString("name");
                                        String weeklySchedule = object.getString("weeklySchedule");


                                        workouts workouts = new workouts(name);
                                        workouts workoutw = new workouts(weeklySchedule,true);
                                        items.add(workouts.getName());
                                        weekscagual.add(workoutw.getWeeklySchedule());
                                    }

                                } catch (Exception e) {

                                }

                                ArrayAdapter<String> adapter = new ArrayAdapter<>(Workout_member.this, android.R.layout.simple_spinner_dropdown_item, items);
                                spinner.setAdapter(adapter);
                                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        if(parent.getItemAtPosition(position).toString().equals("Full time weekly schedule")){
                                            textView.setText(weekscagual.get(position));
                                        }else  if(parent.getItemAtPosition(position).toString().equals("Half-time weekly schedule")){
                                            textView.setText(weekscagual.get(position));
                                        }else  if(parent.getItemAtPosition(position).toString().equals("two days a week")){
                                            textView.setText(weekscagual.get(position));
                                        }else  if(parent.getItemAtPosition(position).toString().equals("Three days a week")){
                                            textView.setText(weekscagual.get(position));
                                        }else  if(parent.getItemAtPosition(position).toString().equals("day a week")){
                                            textView.setText(weekscagual.get(position));
                                        }else  {
                                            textView.setText(weekscagual.get(position));
                                        }


                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });



                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Toast.makeText(Workout_member.this, error.toString(), Toast.LENGTH_LONG).show();

                    }
                });

                queue.add(stringRequest);


            }


        });
        t1.start();

    }


    public void button4(View view) {
        Intent intent = new Intent(Workout_member.this,_Nutritios_chooser.class);
        startActivity(intent);

    }


}
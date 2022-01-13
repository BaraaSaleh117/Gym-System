package com.example.gym_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gym_project.Model.Membership;
import com.example.gym_project.Model.workouts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Workout extends AppCompatActivity {
    private List<workouts> items = new ArrayList<>();
    private RecyclerView recycler;
    private static  final String BASE_URL = "http://10.0.2.2/Gym/get_workouts.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        recycler = findViewById(R.id.recycler);


        recycler.setLayoutManager(new LinearLayoutManager(this));
        loadItems();

    }
    private void loadItems() {


        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {



                        try {

                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i<array.length(); i++){

                                JSONObject object = array.getJSONObject(i);

                                String name = object.getString("name");
                                String weeklySchedule = object.getString("weeklySchedule");




                                workouts workouts = new workouts(name,weeklySchedule);
                                items.add(workouts);
                            }

                        }catch (Exception e){

                        }

                        workoutAdapter adapter = new workoutAdapter(Workout.this,
                                items);
                        recycler.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                Toast.makeText(Workout.this, error.toString(),Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(Workout.this).add(stringRequest);



    }





    public void btnOpen_Click(View view) {
        Intent intent  = new Intent(this, addworkoutschadual.class);

        startActivity(intent);
    }

    public void btnUp_Click(View view) {
        Intent intent  = new Intent(this, UpdateworkoutsS.class);

        startActivity(intent);
    }

    public void btndel_Click(View view) {
        EditText edtCat = findViewById(R.id.edtCat);
        String name = edtCat.getText().toString();
        String url = "http://10.0.2.2/Gym/deleteSchadual.php?name=" + name;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.DELETE, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ArrayList<String> member = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        member.add( obj.getString("name"));
                    }catch(JSONException exception){
                        Log.d("Error", exception.toString());
                    }
                }
                String[] arr = new String[member.size()];
                arr = member.toArray(arr);
                workoutAdapter adapter = new workoutAdapter(Workout.this,
                        items);
                recycler.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

//                Toast.makeText(MainActivity.this, error.toString(),
//                        Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(Workout.this).add(request);
    }

    }


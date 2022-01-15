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
import com.example.gym_project.Model.workouts;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class _MemberShipChooser extends AppCompatActivity {

    private List<String> items = new ArrayList<>();
    private List<String> weekscagual = new ArrayList<>();
    private List<String> Pricee = new ArrayList<>();
    Spinner spinner;
    ArrayList<String> mem;
    private static final String BASE_URL = "http://10.0.2.2/Gym/get_items.php";
    private RequestQueue queue;
    TextView textView ,textView2;
    JSONObject obj = null;
    public static final String SHARD = "shardPrefs";
    public static final String TEXT = "text";
    private String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._member_ship_chooser);
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
                StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {


                                try {

                                    JSONArray array = new JSONArray(response);
                                    for (int i = 0; i < array.length(); i++) {

                                        JSONObject object = array.getJSONObject(i);

                                        String name = object.getString("Mname");
                                        String Mlength = object.getString("Mlength");
                                        String Price = object.getString("Price");


                                        Membership membership = new Membership(name);
                                        Membership membership2 = new Membership(Mlength, true);
                                        Membership membership3 = new Membership(true, Price);


                                        items.add(membership.getMname());
                                        weekscagual.add(membership2.getMlength());
                                        Pricee.add(membership3.getPrice());

                                    }

                                } catch (Exception e) {

                                }

                                ArrayAdapter<String> adapter = new ArrayAdapter<>(_MemberShipChooser.this, android.R.layout.simple_spinner_dropdown_item, items);
                                spinner.setAdapter(adapter);
                                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        if (parent.getItemAtPosition(position).toString().equals("Second offer")) {
                                            textView.setText(weekscagual.get(position));
                                            textView2.setText(Pricee.get(position));
                                        } else if (parent.getItemAtPosition(position).toString().equals("First Offer")) {
                                            textView.setText(weekscagual.get(position));
                                            textView2.setText(Pricee.get(position));
                                        } else if (parent.getItemAtPosition(position).toString().equals("There Offer")) {
                                            textView.setText(weekscagual.get(position));
                                            textView2.setText(Pricee.get(position));
                                        } else if (parent.getItemAtPosition(position).toString().equals("Forth Offers")) {
                                          textView.setText(weekscagual.get(position));
                                            textView2.setText(Pricee.get(position));
                                        } else {
                                            textView2.setText(Pricee.get(position));
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


                        Toast.makeText(_MemberShipChooser.this, error.toString(), Toast.LENGTH_LONG).show();

                    }
                });

                queue.add(stringRequest);


            }


        });
        t1.start();

    }
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARD, MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(TEXT ,textView.getText().toString());
        editor.apply();

        Toast.makeText(this, textView.getText().toString(),Toast.LENGTH_SHORT).show();

    }


    public void button4(View view) {
        saveData();
 Intent intent = new Intent(_MemberShipChooser.this,Workout_member.class);
 startActivity(intent);
    }
}
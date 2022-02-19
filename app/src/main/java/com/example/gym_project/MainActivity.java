package com.example.gym_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    private RequestQueue queue;
    String Name = "";
    String Phone = "";
    String Dj = "";
    String De = "";
    JSONObject obj = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);




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

    public void btnSearch_Click(View view) {
        EditText edtCat = findViewById(R.id.edtCat);
        ListView lst = findViewById(R.id.lstBooks);
        String name = edtCat.getText().toString();
        String url = "http://10.0.2.2/Gym/searchmem.php?name=" + name;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ArrayList<String> mem = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        mem.add( obj.getString("name"));
                    }catch(JSONException exception){
                        Log.d("Error", exception.toString());
                    }
                }
                String[] arr = new String[mem.size()];
                arr = mem.toArray(arr);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        MainActivity.this, android.R.layout.simple_list_item_1,
                        arr);
                lst.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, error.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(request);

    }

    public void btnOpen_Click(View view) {
        Intent intent  = new Intent(this, addmempers.class);

        startActivity(intent);

    }


    public void btnget_Click(View view) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                EditText edtCat = findViewById(R.id.edtCat);
                ListView lst = findViewById(R.id.lstBooks);
                String url = "http://10.0.2.2/Gym/getmembers.php";

                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,
                        null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<String> member = new ArrayList<>();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                obj = response.getJSONObject(i);
                                Name =obj.getString("name");
                                Phone =obj.getString("phone");
                                Dj =obj.getString("DateOfJoining");
                                De =obj.getString("ExpirationDate");
                                member.add(Name);
                            }catch(JSONException exception){
                                Log.d("Error", exception.toString());
                            }
                        }
                        String[] arr = new String[member.size()];
                        arr = member.toArray(arr);
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                MainActivity.this, android.R.layout.simple_list_item_1,
                                arr);
                        lst.setAdapter(adapter);
                        lst.setClickable(true);
                        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent i = new Intent(MainActivity.this,membersDetails.class);
                                i.putExtra("name",Name);
                                i.putExtra("phone",Phone);
                                i.putExtra("DateOfJoining",Dj);
                                i.putExtra("ExpirationDate",De);
                                startActivity(i);

                            }
                        });
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                });

                queue.add(request);


            }


        });
        t1.start();



    }

    public void btndel_Click(View view) {
        EditText edtCat = findViewById(R.id.edtCat);
        ListView lst = findViewById(R.id.lstBooks);
        String name = edtCat.getText().toString();
        String url = "http://10.0.2.2/Gym/deletemember.php?name=" + name;

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
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        MainActivity.this, android.R.layout.simple_list_item_1,
                        arr);
                lst.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

//                Toast.makeText(MainActivity.this, error.toString(),
//                        Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(request);

    }

    public void btnUp_Click(View view) {
        Intent intent  = new Intent(this, UpdateMemberinfo.class);

        startActivity(intent);
    }
}
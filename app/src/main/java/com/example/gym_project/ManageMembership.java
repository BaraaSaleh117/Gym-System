package com.example.gym_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gym_project.Model.Membership;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ManageMembership extends AppCompatActivity {
    private List<Membership> items = new ArrayList<>();
    private RecyclerView recycler;
    private static  final String BASE_URL = "http://10.0.2.2/Gym/get_items.php";
    boolean flag = false ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclarview);

        recycler = findViewById(R.id.recycler);


        recycler.setLayoutManager(new LinearLayoutManager(this));
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
                StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {



                                try {

                                    JSONArray array = new JSONArray(response);
                                    for (int i = 0; i<array.length(); i++){

                                        JSONObject object = array.getJSONObject(i);

                                        String Mname = object.getString("Mname");
                                        String Mlength = object.getString("Mlength");
                                        String Price = object.getString("Price");



                                        Membership membership = new Membership(Mname,Mlength,Price);
                                        items.add(membership);
                                    }

                                }catch (Exception e){

                                }

                                MembershipAdapter adapter = new MembershipAdapter(ManageMembership.this,
                                        items);
                                recycler.setAdapter(adapter);

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Toast.makeText(ManageMembership.this, error.toString(),Toast.LENGTH_LONG).show();

                    }
                });

                Volley.newRequestQueue(ManageMembership.this).add(stringRequest);
            }
        });
        t1.start();






    }





    public void btnOpen_Click(View view) {
        Intent intent  = new Intent(this, AddOffer.class);

        startActivity(intent);
    }

    public void btnUp_Click(View view) {
        Intent intent  = new Intent(this, UpdateOffers.class);

        startActivity(intent);
    }

    public void btndel_Click(View view) {
        EditText edtCat = findViewById(R.id.edtCat);
        String Mname = edtCat.getText().toString();
        String url = "http://10.0.2.2/Gym/deleteOffer.php?Mname=" + Mname;

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
                MembershipAdapter adapter = new MembershipAdapter(ManageMembership.this,
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

        Volley.newRequestQueue(ManageMembership.this).add(request);
    }


}
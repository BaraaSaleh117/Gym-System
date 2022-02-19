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

import java.util.ArrayList;

public class WebActivity extends AppCompatActivity {
    private RequestQueue queue;
    String title = "";
    String location_type ="";
    JSONObject obj = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        queue = Volley.newRequestQueue(this);
    }

    public void btnget_Click(View view) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                EditText edtCat = findViewById(R.id.edtCat);
                ListView lst = findViewById(R.id.lstBooks);
                String url = "https://www.metaweather.com/api/location/search/?query=london";

                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,
                        null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<String> member = new ArrayList<>();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                obj = response.getJSONObject(i);
                                location_type =obj.getString("location_type");

                                title =obj.getString("title");

                                member.add(title);

                            }catch(JSONException exception){
                                Log.d("Error", exception.toString());
                            }
                        }
                        String[] arr = new String[member.size()];
                        arr = member.toArray(arr);
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                WebActivity.this, android.R.layout.simple_list_item_1,
                                arr);
                        lst.setAdapter(adapter);
                        lst.setClickable(true);
                        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                            }
                        });
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(WebActivity.this, error.toString(),
                                Toast.LENGTH_LONG).show();

                    }
                });

                queue.add(request);


            }


        });
        t1.start();



    }
}
package com.example.gym_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class addmempers extends AppCompatActivity {
    private EditText edtname, edtphone, edtDj,edtEd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmempers);
        edtname = findViewById(R.id.edtTitleu);
        edtphone = findViewById(R.id.edtCategoryu);
        edtDj = findViewById(R.id.edtPagesu);
        edtEd = findViewById(R.id.edtPagesu2);
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

    public void btnAdd_Click(View view) {
        String name = edtname.getText().toString();
        String Phone = edtphone.getText().toString();
        String DateOfJoining = edtDj.getText().toString();
        String ExpirationDate = edtEd.getText().toString();

        addMember(name, Phone, DateOfJoining ,ExpirationDate);
    }

    private void addMember(String name, String Phone, String DateOfJoining ,String ExpirationDate){
        String url = "http://10.0.2.2/Gym/addMember.php";
        RequestQueue queue = Volley.newRequestQueue(addmempers.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(addmempers.this,
                            jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(addmempers.this,
                        "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our
                // key and value pair to our parameters.
                params.put("name", name);
                params.put("phone", Phone);
                params.put("DateOfJoining", DateOfJoining);
                params.put("ExpirationDate", ExpirationDate);

                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }

}
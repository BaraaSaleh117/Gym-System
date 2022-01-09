package com.example.gym_project;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
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
public class UpdateMemberinfo extends AppCompatActivity {
    private EditText edtTitle, edtPages,edtPages3,edtPages4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_members_info);
        edtTitle = findViewById(R.id.edtTitleu);
        edtPages = findViewById(R.id.edtPagesu);
        edtPages3 = findViewById(R.id.edtPagesu3);
        edtPages4 = findViewById(R.id.edtPagesu4);
    }

    public void btnUp_Click(View view) {
        String name = edtTitle.getText().toString();
        String phone = edtPages.getText().toString();
        String DateOfJoining = edtPages3.getText().toString();
        String ExpirationDate = edtPages4.getText().toString();

        UpdateBook(name,phone, DateOfJoining,ExpirationDate);
    }

    private void UpdateBook(String name, String phone,String DateOfJoining ,String ExpirationDate ){
        ListView lst = findViewById(R.id.lstBooks);
        String url = "http://10.0.2.2/Gym/updateM.php?name="+name+"&phone="+phone+"&DateOfJoining="+DateOfJoining+"&ExpirationDate="+ExpirationDate ;
        RequestQueue queue = Volley.newRequestQueue(UpdateMemberinfo.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(UpdateMemberinfo.this,
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
                params.put("phone", phone);
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
package com.example.gym_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class _Members_Profile extends AppCompatActivity {
    private String text ,text2 ,text3;
    public static final String TEXT = "text";
    public static final String TEXTT = "textt";
    public static final String TEX = "t";
    public static final String SHARD_PREFS = "shardPrefss";
    public static final String SHARD = "shardPrefs";
    public static final String PREFS = "Pref";
    TextView textView ,textVieww,textViewn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._members_profile);
        textView = findViewById(R.id.textView16);
        textVieww = findViewById(R.id.textView17);
        textViewn= findViewById(R.id.textView19);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARD_PREFS, MODE_PRIVATE);
        SharedPreferences shared = getSharedPreferences(SHARD, MODE_PRIVATE);
        SharedPreferences PREF = getSharedPreferences(PREFS, MODE_PRIVATE);

        text=shared.getString(TEXT,"");
        text2=sharedPreferences.getString(TEXTT,"");
        text3=PREF.getString(TEX,"");

        textView.setText(text);
        textVieww.setText(text2);
        textViewn.setText(text3);
    }
}
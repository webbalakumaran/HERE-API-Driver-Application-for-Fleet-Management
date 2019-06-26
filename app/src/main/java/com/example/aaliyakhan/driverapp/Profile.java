package com.example.aaliyakhan.driverapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    public static final String DEFAULT="N/A";
    TextView txt,tent,twist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");
        txt=findViewById(R.id.txtr);
        tent=findViewById(R.id.txt4);
        twist=findViewById(R.id.txt5);
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
        String email=sharedPreferences.getString("email",DEFAULT);
        String name = sharedPreferences.getString("name",DEFAULT);
        String phone=sharedPreferences.getString("phone",DEFAULT);
        String passname =  sharedPreferences.getString("password",DEFAULT);
        if (name.equals(DEFAULT) || passname.equals(DEFAULT)){
            Toast.makeText(this,"loading details not found",Toast.LENGTH_SHORT).show();
        }
        else {
            txt.setText(name);
            tent.setText(email);
            twist.setText(phone);
        }
    }
}

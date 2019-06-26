package com.example.aaliyakhan.driverapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class Login extends AppCompatActivity {
    EditText user,pass,mail,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        user=findViewById(R.id.username);
        pass=findViewById(R.id.password);
        mail=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
    }
    public void save(View view){
        SharedPreferences sharedPref = getSharedPreferences("MyData",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("name",user.getText().toString());
        editor.putString("password",pass.getText().toString());
        editor.putString("email",mail.getText().toString());
        editor.putString("phone",phone.getText().toString());
        editor.commit();
        Toast.makeText(this, "Your details has been save" , Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);


    }

}
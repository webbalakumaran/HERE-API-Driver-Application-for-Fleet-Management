package com.example.aaliyakhan.driverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Help extends AppCompatActivity {
    Button send;
    RadioGroup radioGroup;
    EditText problem;
    String status="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        setTitle("Help");
        radioGroup=findViewById(R.id.radiogroup);
        send=findViewById(R.id.send);
        problem=findViewById(R.id.problemtext);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton=findViewById(id);
                status=radioButton.getText().toString();
                if(radioButton.getText().equals("Others")){
                    problem.setVisibility(View.VISIBLE);
                    status=problem.getText().toString();
                }
                Toast.makeText(Help.this, "Help request for "+status+" has been sent!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

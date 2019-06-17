package com.example.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button login;
    TextView  register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
         register= (TextView)findViewById(R.id. register);
        login= (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userLogin();


            }
        });
    }
    public void userLogin(){

       String email= email.getText().toString().trim();
       String password= password.getText().toString().trim();

       if (email.isEmpty()){
           Toast.makeText(MainActivity.this, "Enter  Email Please!",Toast.LENGTH_LONG).show();
       }
        if (password.isEmpty()){
            Toast.makeText(MainActivity.this, "Enter the Password Please!",Toast.LENGTH_LONG).show();
        }

        if (email.equals("joselumulungi") && password.equals("0780812297")){
            Toast.makeText(MainActivity.this, "wouuu congz!",Toast.LENGTH_LONG).show();
            Intent gotoregister= new Intent(MainActivity.this, Registerhere.class);
            startActivity(gotoregister);
        }

        else {

            Toast.makeText(MainActivity.this, "sorrt try again",Toast.LENGTH_LONG).show();
        }
    }





}

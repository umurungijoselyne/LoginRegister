package com.example.loginapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registerhere extends AppCompatActivity{
    private FirebaseAuth mAuth;
    EditText mail,pass;
    Button register;
    TextView login;
    public void userRegister(){

        String email= mail.getText().toString().trim();
        String password= pass.getText().toString().trim();

        if (email.isEmpty()){
            Toast.makeText(Registerhere.this, "Please your Email!",Toast.LENGTH_LONG).show();
        }
        if (password.isEmpty()){
            Toast.makeText(Registerhere.this, "Please the Password!",Toast.LENGTH_LONG).show();
        }

        else {

            // we are going to regisrter our user here

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){

                        Toast.makeText(Registerhere.this, "User successfully registered.",Toast.LENGTH_LONG).show();

                    }
                }
            });






        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerhere);
        mAuth = FirebaseAuth.getInstance();
        mail=(EditText)findViewById(R.id.mail);
        pass=(EditText)findViewById(R.id.pass);
        login= (TextView)findViewById(R.id.login);
        register= (Button)findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegister();
            }
        });





    }
}

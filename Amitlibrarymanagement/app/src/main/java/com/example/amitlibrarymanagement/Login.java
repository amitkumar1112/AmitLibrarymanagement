package com.example.amitlibrarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    TextView textView;
    EditText editText11,editText12;
    Button button22;
    String email,password;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView =findViewById(R.id.Signup1);
        editText11 =findViewById(R.id.ed11);
        editText12 =findViewById(R.id.ed12);
        button22 =findViewById(R.id.Button1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gosignup = new Intent(Login.this,Signup.class);
                startActivity(gosignup);
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = editText11.getText().toString().trim();
                password = editText12.getText().toString().trim();
                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(Login.this,"email and password can't be empty",Toast.LENGTH_SHORT).show();
                }
                else if (email.contains("@gmail.com") && ((password.length()>4) && (password.length()<10))) {
                    Intent i = new Intent(Login.this,welcome.class);
                    i.putExtra("email",email);
                    startActivity(i);
                    Toast.makeText(Login.this,"User valid",Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(Login.this,"Invalid email or password",Toast.LENGTH_SHORT).show();
                    if((password.length()>4) && (password.length()<10)){
                        Toast.makeText(Login.this," password length greater than 4 and 10",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}


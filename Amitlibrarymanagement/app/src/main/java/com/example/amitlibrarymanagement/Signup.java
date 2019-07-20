package com.example.amitlibrarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    TextView textView;
    Button button3;
    String name, email, password,phone22, cnfpassword,end = "@gmail.com";
    EditText editText1, editText2,editText3, editText4, editText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        textView = findViewById(R.id.login1);
        button3 = findViewById(R.id.Button1);
        editText1 =findViewById(R.id.nameedit);
        editText2 = findViewById(R.id.email1l);
        editText3 =findViewById(R.id.phone2);
        editText4 =findViewById(R.id.pass1);
        editText5 =findViewById(R.id.cnfpass);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin1 = new Intent(Signup.this, Login.class);
                startActivity(gologin1);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editText1.getText().toString().trim();
                email = editText2.getText().toString().trim();
                phone22 = editText3.getText().toString().trim();
                password = editText4.getText().toString().trim();
                cnfpassword =editText5.getText().toString().trim();

                if(name.isEmpty() || email.isEmpty() ||password.isEmpty() || cnfpassword.isEmpty()){
                    Toast.makeText(Signup.this," Fill all the fields",Toast.LENGTH_SHORT).show();
                }
                else if(name.length()<4 ){
                    Toast.makeText(Signup.this, " enter a valid name",Toast.LENGTH_SHORT).show();
                }
                else if(!email.contains("@gmail.com")){
                    editText2.setText(email.concat(end));
                }
                else if(phone22.length()!=10){
                    Toast.makeText(Signup.this,"enter a valid 10 digit phone number",Toast.LENGTH_SHORT).show();
                }
                else if (password.length()<=4 || password.length()>=10){
                    Toast.makeText(Signup.this,"password length should be of proper length",Toast.LENGTH_SHORT).show();
                }
                else if(!cnfpassword.equals(password)){
                    Toast.makeText(Signup.this,"both password field should be same",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent go = new Intent(Signup.this,signupuser.class);
                    go.putExtra("name",name);
                    startActivity(go);

                }

              /*  if (name.isEmpty() || email.isEmpty() ||password.isEmpty() || cnfpassword.isEmpty()){
                    Toast.makeText(Signup.this,"All fields are mandatory",Toast.LENGTH_SHORT).show();
                }
                else if (email.contains("@.com") && ((password.length()>4) && (password.length()<10)) || !cnfpassword.equals(password)) {
                    Intent i = new Intent(Signup.this,signupuser.class);
                    i.putExtra("email",email);
                    startActivity(i);
                    Toast.makeText(Signup.this,"Sign up successful",Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(Signup.this,"SOmething in fields are missing or may be inappropriate entry",Toast.LENGTH_LONG).show();
                }*/



            }
        });
    }
}


package com.example.amitlibrarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Signup extends AppCompatActivity {
    TextView textView;
    Button button3, button4;
    String name, email, password, phone, confirmpass, end = "@gmail.com";
    EditText editText1, editText2, editText3, editText4, editText5;
    Mysignuphelper mysignuphelper;
    ListView infoListview;
    ArrayList<infosignup> infoArrayList;
    Adapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        textView = findViewById(R.id.login1);
        button3 = findViewById(R.id.Button1);
        editText1 = findViewById(R.id.nameedit);
        editText2 = findViewById(R.id.email1l);
        editText3 = findViewById(R.id.phone2);
        editText4 = findViewById(R.id.pass1);
        editText5 = findViewById(R.id.cnfpass);
        button4 = findViewById(R.id.btt);
        mysignuphelper = new Mysignuphelper(Signup.this, null);

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
                name = editText1.getText().toString();
                email = editText2.getText().toString();
                phone = editText3.getText().toString();
                password = editText4.getText().toString();
                confirmpass = editText5.getText().toString();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmpass.isEmpty()) {
                    Toast.makeText(Signup.this, " Fill all the fields", Toast.LENGTH_SHORT).show();
                } else if (name.length() < 4) {
                    Toast.makeText(Signup.this, " enter a valid name", Toast.LENGTH_SHORT).show();
                } else if (!email.contains("@gmail.com")) {
                    editText2.setText(email.concat(end));
                } else if (phone.length() != 10) {
                    Toast.makeText(Signup.this, "enter a valid 10 digit phone number", Toast.LENGTH_SHORT).show();
                } else if (password.length() <= 4 || password.length() >= 10) {
                    Toast.makeText(Signup.this, "password length should be of proper length", Toast.LENGTH_SHORT).show();
                } else if (!confirmpass.equals(password)) {
                    Toast.makeText(Signup.this, "both password field should be same", Toast.LENGTH_SHORT).show();
                } else {
                    infosignup info = new infosignup(name, email, phone, password, confirmpass);
                    mysignuphelper.addinfo(info);
                    Toast.makeText(Signup.this, "info recorded", Toast.LENGTH_SHORT).show();
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");

                 /*   Intent go = new Intent(Signup.this,signupuser.class);
                    go.putExtra("name",name);
                    startActivity(go);*/

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
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Signup.this, listview1.class);
                startActivity(i);
                loadinfo();
            }
        });
    }

    private void loadinfo() {
        mysignuphelper = new Mysignuphelper(Signup.this, null);
        infoArrayList = mysignuphelper.loadallinfo();
        if (infoArrayList.size() != 0) {
            adapter1 = new Adapter(Signup.this, infoArrayList);
            infoListview = findViewById(R.id.list1);
            infoListview.setAdapter(adapter1);
        }
    }
}


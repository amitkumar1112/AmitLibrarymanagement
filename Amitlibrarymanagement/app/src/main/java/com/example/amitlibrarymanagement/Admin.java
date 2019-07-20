package com.example.amitlibrarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends AppCompatActivity {

    EditText editText1,editText2;
    Button button2;
    String user = "USER",password = "1111",getuser,getpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        editText1 = findViewById(R.id.ed1);
        editText2 = findViewById(R.id.ed452);
        button2 = findViewById(R.id.Button2222);

        button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               getuser = editText1.getText().toString().trim();
               getpassword =editText2.getText().toString().trim();
               if(getuser.isEmpty() || getpassword.isEmpty()){
                   if(getuser.isEmpty()){
                       Toast.makeText(Admin.this, "Username can't be empty", Toast.LENGTH_SHORT).show();
                   }
                   else if(getuser.equals(user)){
                       getuser = user;
                       Toast.makeText(Admin.this,"Valid Admin" +getuser,Toast.LENGTH_SHORT).show();
                   }
                   else{
                       Toast.makeText(Admin.this,getuser+"is not a valid name",Toast.LENGTH_SHORT).show();
                   }
                   if(getpassword.isEmpty()){
                       Toast.makeText(Admin.this, "Password can't be empty", Toast.LENGTH_SHORT).show();
                   }
                   else if(getpassword.equals(password)){
                       getpassword = password;
                       Toast.makeText(Admin.this,"Valid Admin" +getpassword,Toast.LENGTH_SHORT).show();
                   }
                   else{
                       Toast.makeText(Admin.this," not a valid password",Toast.LENGTH_SHORT).show();
                   }
               }
               else if(getuser.equals(user) && getpassword.equals(password)){
                   Intent go = new Intent(Admin.this,books_management.class);
                   startActivity(go);
               }
               else{
                   Toast.makeText(Admin.this,"User name or password is wrong",Toast.LENGTH_SHORT).show();
               }
           }
       });


    }

}

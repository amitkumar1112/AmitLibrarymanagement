package com.example.amitlibrarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class signupuser extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupuser);
        button = findViewById(R.id.bt7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r =getIntent();
                String t = (String)r.getSerializableExtra("name");
                Log.i("hello",""+t);

                Toast.makeText(signupuser.this,"Welcome"+" "+t,Toast.LENGTH_LONG).show();

            }
        });


    }
}

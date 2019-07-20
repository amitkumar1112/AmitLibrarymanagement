package com.example.amitlibrarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class welcome extends AppCompatActivity {
    Button button21;
    RelativeLayout relativeLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        button21 = findViewById(R.id.bt1);
        relativeLayout1 = findViewById(R.id.relatee);

        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r = getIntent();
                String t = (String)r.getSerializableExtra("email");
                Log.i("hello",""+t);

                TextView tv1 = new TextView(welcome.this);
                relativeLayout1.addView(tv1);
                tv1.setText("WELCOME "+" "+t);


                Toast.makeText(welcome.this,"Welcome"+t,Toast.LENGTH_LONG).show();

            }
        });




    }
}

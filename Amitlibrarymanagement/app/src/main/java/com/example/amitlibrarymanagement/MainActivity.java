package com.example.amitlibrarymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button button1,button2;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 =findViewById(R.id.Button1);
        button2 =findViewById(R.id.Button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gologin = new Intent(MainActivity.this,Login.class);
                startActivity(gologin);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goadmin = new Intent(MainActivity.this,Admin.class);
                startActivity(goadmin);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.id7){
            Intent issue = new Intent(MainActivity.this, issue.class);
            startActivity(issue);
            return true;
        }
        if(id==R.id.id6){
            Intent returne = new Intent(MainActivity.this,returnw.class);
            startActivity(returne);
            return true;
        }
        return true;
    }

}

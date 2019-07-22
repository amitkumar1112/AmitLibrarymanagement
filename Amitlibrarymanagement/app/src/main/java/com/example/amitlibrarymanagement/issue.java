package com.example.amitlibrarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class issue extends AppCompatActivity {
    Button button1;
    String booksname,authorname;
    EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);
        button1 =findViewById(R.id.buttonn11);
        editText1 =findViewById(R.id.bname1);
        editText2 =findViewById(R.id.author1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                booksname =editText1.getText().toString().trim();
                authorname = editText2.getText().toString().trim();

                if(booksname.isEmpty() || authorname.isEmpty()){
                    if(booksname.length()<=3){
                        editText1.setError("bookname can not be empty");
                    }
                    else{
                        editText1.setError(null);
                    }
                    if (authorname.length()<=3){
                        editText2.setError("author name cannot be empty");
                    }
                    else{
                        editText2.setError(null);
                    }
                }
                else {
                    Intent issuebooks = new Intent(issue.this,Login.class);
                    startActivity(issuebooks);
                    Toast.makeText(issue.this,"book added",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}

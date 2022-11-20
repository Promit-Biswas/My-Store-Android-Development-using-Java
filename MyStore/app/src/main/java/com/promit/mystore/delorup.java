package com.promit.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class delorup extends AppCompatActivity {
    Button abtn;
    Button bbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delorup);
        abtn = (Button) findViewById(R.id.btndelete);
        bbtn = (Button) findViewById(R.id.btnupdate);
        abtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add=new Intent(delorup.this,delete.class);
                startActivity(add);
            }
        });
        bbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adds=new Intent(delorup.this,updateinfo.class);
                startActivity(adds);
            }
        });
    }
}

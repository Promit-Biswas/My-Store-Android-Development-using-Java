package com.promit.mystore;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class HomeActivity extends AppCompatActivity {
    Button abtn;
    Button bbtn;
    Button cbtn;
    Button dbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        abtn = (Button) findViewById(R.id.btnadd);
        bbtn = (Button) findViewById(R.id.btnshpinfo);
        dbtn = (Button) findViewById(R.id.btnabout);
        cbtn = (Button) findViewById(R.id.btnsell);
        abtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add=new Intent(HomeActivity.this,addingitem.class);
                startActivity(add);
            }
        });
        bbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adds=new Intent(HomeActivity.this,shopinfo.class);
                startActivity(adds);
            }
        });
        cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sell=new Intent(HomeActivity.this,sellinfo.class);
                startActivity(sell);
            }
        });
        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about=new Intent(HomeActivity.this,about.class);
                startActivity(about);
            }
        });

    }
}

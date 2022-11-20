package com.promit.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateinfo extends AppCompatActivity {
    Button abtn;
    EditText mitem;
    EditText mtaka;
    EditText mqnty;
    EditText midup;
    private DatabaseHelper databaseHelper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateinfo);
        abtn = (Button) findViewById(R.id.btnupdate2);
        mitem = (EditText) findViewById(R.id.itemup);
        mtaka = (EditText) findViewById(R.id.Rateup);
        mqnty = (EditText) findViewById(R.id.qunatityup);
        midup = (EditText) findViewById(R.id.idup);
        abtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ids=midup.getText().toString();
                String id=mitem.getText().toString().trim();
                String price=mtaka.getText().toString();
                String quantity=mqnty.getText().toString();
                if(id.equals("")&&price.equals("")&& quantity.equals(""))
                {
                    Toast.makeText(updateinfo.this,"Please add item",Toast.LENGTH_SHORT).show();
                }
                else {
                   Boolean isupdate= databaseHelper.update(ids,id,price,quantity);
                   if(isupdate==true)
                   {
                       Toast.makeText(updateinfo.this,"Data is updated",Toast.LENGTH_SHORT).show();
                       Intent add = new Intent(updateinfo.this, shopinfo.class);
                       startActivity(add);
                   }
                   else
                   {
                       Toast.makeText(updateinfo.this,"Data is not updated",Toast.LENGTH_SHORT).show();
                   }

                }
            }
        });
    }
}

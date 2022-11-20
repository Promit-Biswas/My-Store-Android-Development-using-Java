package com.promit.mystore;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class addingitem extends AppCompatActivity {
    Button abtn;
    EditText mitem;
    EditText mtaka;
    EditText mqnty;
    private DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addingitem);
        this.setTitle("Add Items");
        abtn = (Button) findViewById(R.id.btnadditem);
        mitem = (EditText) findViewById(R.id.item);
        mtaka = (EditText) findViewById(R.id.Rate);
        mqnty = (EditText) findViewById(R.id.qunatity);
        SQLiteDatabase sqLiteDatabase;
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        abtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=mitem.getText().toString().trim();
                String price=mtaka.getText().toString();
                String quantity=mqnty.getText().toString();
                if(id.equals("")&&price.equals("")&& quantity.equals(""))
                {
                    Toast.makeText(addingitem.this,"Please add item",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    long rownumber= databaseHelper.saveData( id, price, quantity);
                    if(rownumber>-1)
                    {
                        Intent add=new Intent(addingitem.this,HomeActivity.class);
                        startActivity(add);
                        Toast.makeText(addingitem.this,"Item Added Successfully",Toast.LENGTH_SHORT).show();
                        mitem.setText("");
                        mtaka.setText("");
                        mqnty.setText("");
                    }
                    else
                    {
                        Toast.makeText(addingitem.this,"Item Added not Successfully",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}


package com.promit.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete extends AppCompatActivity {
    EditText mId;
    Button mDelete;
    private DatabaseHelper databaseHelper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        mId = (EditText)findViewById(R.id.del);
        mDelete = (Button)findViewById(R.id.btndel);
        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=mId.getText().toString();
                int value= databaseHelper.delete(id);
                if(value<0)
                {
                    Toast.makeText(delete.this,"Not Deleted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(delete.this,"Deleted",Toast.LENGTH_SHORT).show();
                    Intent add=new Intent(delete.this,shopinfo.class);
                    startActivity(add);
                }
            }
        });
    }
}

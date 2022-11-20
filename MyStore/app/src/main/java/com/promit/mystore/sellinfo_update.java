package com.promit.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sellinfo_update extends AppCompatActivity {
        EditText mId;
        EditText mqnty;
        Button mDelete;
        private DatabaseHelper databaseHelper = new DatabaseHelper(this);
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sellinfo_update);
            mId= (EditText)findViewById(R.id.idsellup);
            mqnty= (EditText)findViewById(R.id.Ratesellup);
            mDelete = (Button)findViewById(R.id.btnsellup);
            mDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id=mId.getText().toString();
                    String idss=mqnty.getText().toString();
                    Boolean isupdate= databaseHelper.update2(id,idss);
                    if(isupdate==true)
                    {
                        Toast.makeText(sellinfo_update.this,"Data is updated",Toast.LENGTH_SHORT).show();
                        Intent add = new Intent(sellinfo_update.this, sellinfo.class);
                        startActivity(add);
                        mId.setText("");
                        mqnty.setText("");

                    }
                    else
                    {
                        Toast.makeText(sellinfo_update.this,"Data is not updated",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
}

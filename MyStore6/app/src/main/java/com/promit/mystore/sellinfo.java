package com.promit.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class sellinfo extends AppCompatActivity {

    private ListView listView;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellinfo);
        this.setTitle("Sell Info");
        listView=(ListView) findViewById(R.id.listview2);
        databaseHelper= new DatabaseHelper(this);
        loaddata();
    }
    public void loaddata()
    {
        ArrayList<String> ListData= new ArrayList<>();
        Cursor cursor= databaseHelper.showAllData();
        if(cursor.getCount()==0)
        {
            Toast.makeText(sellinfo.this,"Faka Kiccu nai",Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                ListData.add("ID: "+cursor.getString(0)+"\nName: "+cursor.getString(1)+"\nPrice: "+cursor.getString(2)+"\nQuantity: "+cursor.getString(3));
            }
        }
        ArrayAdapter<String> adapter= new ArrayAdapter<String >(this,R.layout.item,R.id.textView2,ListData);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdapterView, View view, int i, long l) {
                String selectedValue = AdapterView.getItemAtPosition(i).toString();
                Intent adds=new Intent(sellinfo.this,sellinfo_update.class);
                startActivity(adds);
                Toast.makeText(getApplicationContext(),""+selectedValue,Toast.LENGTH_SHORT).show();
            }
        });
    }
}

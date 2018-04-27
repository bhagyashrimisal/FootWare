package com.example.rohini.footware;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
DatabaseNotice mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listView = (ListView)findViewById(R.id.lv);
        mydb = new DatabaseNotice(this);
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = mydb.getListContents();
        if (data.getCount() == 0){
            Toast.makeText(getApplicationContext(),"The Database Was Empty",Toast.LENGTH_LONG).show();

        }
        else {
            while(data.moveToNext()) {
                theList.add(data.getString(1));
                ListAdapter i = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(i);
            }
        }
    }
}

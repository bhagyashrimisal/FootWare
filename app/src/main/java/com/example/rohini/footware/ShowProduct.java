package com.example.rohini.footware;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowProduct extends AppCompatActivity {
    DatabaseNotice mydb;
    private ListView listView;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);
            if (getSupportActionBar () != null) {
                getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
                getSupportActionBar ().setDisplayShowHomeEnabled (true);
            }
            b1 = (Button) findViewById (R.id.btdelete);
            ListView listView = (ListView) findViewById (R.id.listview);
            mydb = new DatabaseNotice (this);
            ArrayList<String> theList = new ArrayList<> ();
            Cursor data = mydb.getListContents ();
            if (data.getCount () == 0) {
                Toast.makeText (getApplicationContext (), "The Database Was Empty", Toast.LENGTH_LONG).show ();

            } else {
                while (data.moveToNext ()) {
                    theList.add (data.getString (0));
                    theList.add (data.getString (1));
                    ListAdapter i = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                    listView.setAdapter (i);
                }
            }

            b1.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent (ShowProduct.this, DeleteProducts.class);
                    startActivity (i);

                }
            });
        }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId () == android.R.id.home)
            finish ();
        return super.onOptionsItemSelected (item);
    }
}

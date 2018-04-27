package com.example.rohini.footware;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProductsAdd extends AppCompatActivity {
    EditText editText;
    Button b1, b2;
    DatabaseNotice mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_add);

            if (getSupportActionBar () != null) {
                getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
                getSupportActionBar ().setDisplayShowHomeEnabled (true);
            }

            mydb = new DatabaseNotice(this);      //inializing new variable mydb
            editText = (EditText) findViewById (R.id.etsub);
            b1 = (Button) findViewById (R.id.btadn);
            b2 = (Button) findViewById (R.id.btan);

            b2.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent (ProductsAdd.this, ShowProduct.class);
                    startActivity (i);
                }
            });


            b1.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    String s1 = editText.getText ().toString ();
                    if (editText.length () != 0) {
                        AddData (s1);          //calling for method adddata from this activity
                    } else {
                        Toast.makeText (getApplicationContext (), "you must put something in the field", Toast.LENGTH_LONG).show ();
                    }
                }
            });
        }

    public void AddData(String s1)
    {
        boolean insertData = mydb.addData (s1);   //here s1 is the formal parameter for message in database

        if (insertData == true)
        {
            Toast.makeText (getApplicationContext (), "Successfully Entered Shoes Details", Toast.LENGTH_LONG).show ();

        } else
        {
            Toast.makeText (getApplicationContext (), "SOrry....Something went wrong", Toast.LENGTH_LONG).show ();

        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId () == android.R.id.home)
            finish ();
        return super.onOptionsItemSelected (item);
    }
}

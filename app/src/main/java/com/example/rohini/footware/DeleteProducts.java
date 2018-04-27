package com.example.rohini.footware;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteProducts extends AppCompatActivity {
    DatabaseForUpdate mydb;
    EditText number;
    Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_products);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mydb = new DatabaseForUpdate(this);
        number = findViewById(R.id.etdelete);
        but = findViewById(R.id.b1);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mydb.deleteData(number.getText().toString());
                Toast.makeText(getApplicationContext(), "Delete Successfully", Toast.LENGTH_LONG).show();
                Intent i = new Intent(DeleteProducts.this, ShowProduct.class);
                startActivity(i);

            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}

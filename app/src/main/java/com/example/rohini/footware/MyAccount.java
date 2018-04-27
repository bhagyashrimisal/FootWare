package com.example.rohini.footware;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyAccount extends AppCompatActivity {
Button ins,up,del,vie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        ins=(Button) findViewById(R.id.insert);
        up=(Button) findViewById(R.id.update);
        del=(Button) findViewById(R.id.delete);
        vie=(Button) findViewById(R.id.view);
    }

    public void Insert(View view)
    {
        Intent intent=new Intent(MyAccount.this,ProductsAdd.class);
        startActivity(intent);
    }

    public void Delete(View view) {
        Intent intent=new Intent(MyAccount.this,DeleteProducts.class);
        startActivity(intent);
    }

    public void View(View view) {
        Intent intent=new Intent(MyAccount.this,ShowProduct.class);
        startActivity(intent);
    }

    public void Update(View view) {
       Intent intent=new Intent(MyAccount.this,UpdateProduct.class);
        startActivity(intent);
    }
}

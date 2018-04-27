package com.example.rohini.footware;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HighHeel extends AppCompatActivity {
Button buy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_heel);
        buy=(Button) findViewById(R.id.button3);
    }


    public void Buy(View view) {
      //  Intent intent=new Intent(HighHeel.this,);
        //startActivity(intent);
    }
}

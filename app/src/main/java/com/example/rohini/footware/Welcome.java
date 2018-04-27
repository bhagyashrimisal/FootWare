package com.example.rohini.footware;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Welcome extends AppCompatActivity {
    public class MainActivity extends AppCompatActivity {
        RelativeLayout rl;
        Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById (R.id.b1);
        b2 = findViewById (R.id.b2);
        b1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, MainActivity.class);   //login
                startActivity (intent);
            }
        });
        b2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, MainActivity.class);  //register
                startActivity (intent);

            }
        });

    }
    }
}

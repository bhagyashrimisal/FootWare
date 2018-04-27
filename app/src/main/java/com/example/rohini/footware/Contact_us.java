package com.example.rohini.footware;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohini.footware.R;

public class Contact_us extends AppCompatActivity {
    Button btn1, btn2;
    TextView t1,t2,t3,numTxt;
    String sNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);
        if (getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

         t1=(TextView)findViewById(R.id.text1);
         numTxt=(TextView) findViewById(R.id.text2);
         t3=(TextView) findViewById(R.id.text2);
    }

    public void btnClick(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("email"));
        String[] s = {"abc@gmail.com", "xyz@gmail.com"};
        i.putExtra(Intent.EXTRA_EMAIL, s);
        i.putExtra(Intent.EXTRA_SUBJECT, "This is a subject");
        i.putExtra(Intent.EXTRA_TEXT, "Hii This is the Email Body");
        i.setType("message/rfc822");
        Intent Chosser = Intent.createChooser(i, "Launch Email");
        startActivity(Chosser);



        // public void btnClick(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        sNum = numTxt.getText().toString();
        if (sNum.trim().isEmpty()) {
            i.setData(Uri.parse("tel:8806986311"));
        } else {
            i.setData(Uri.parse("tel:" + sNum));
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Please grant yhe permission to call", Toast.LENGTH_SHORT).show();
            requestPermissions();
        } else {
            startActivity(i);
        }

    }

    private void requestPermissions() {

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
    }


    public void btnCall(View view) {

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }


}
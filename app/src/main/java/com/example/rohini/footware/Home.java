package com.example.rohini.footware;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
ImageView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        l1=(ImageView) findViewById(R.id.highheel);
        l2=(ImageView) findViewById(R.id.flat);
        l3=(ImageView) findViewById(R.id.flatsleeper);
        l4=(ImageView) findViewById(R.id.pencilheel);
        l5=(ImageView) findViewById(R.id.shoe);
        l6=(ImageView) findViewById(R.id.sideheel);
        l7=(ImageView) findViewById(R.id.boxheel);
        l8=(ImageView) findViewById(R.id.keto);
        l9=(ImageView) findViewById(R.id.pointheel);
        l10=(ImageView) findViewById(R.id.sandle);
        //l1=(ImageView) findViewById(R.id.highheel);
        //l1=(ImageView) findViewById(R.id.highheel);
        //l1=(ImageView) findViewById(R.id.highheel);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Home.this,HighHeel.class);
                startActivity(intent);
            }
        });


        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Home.this,Flat.class);
                startActivity(intent);
            }
        });


        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Home.this,FlatSleeper.class);
                startActivity(intent);
            }
        });


        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Home.this,PencilHeel.class);
                startActivity(intent);
            }
        });


        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Home.this,Shoe.class);
                startActivity(intent);
            }
        });

        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Home.this,SideHeel.class);
                startActivity(intent);
            }
        });


        l7.setOnClickListener(new View.OnClickListener() {@Override
            public void onClick(View v) {

                Intent intent=new Intent(Home.this,BoxHeel.class);
                startActivity(intent);
            }
        });


        l8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Home.this,Keto.class);
                startActivity(intent);
            }
        });

        l9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Home.this,PointHeel.class);
                startActivity(intent);
            }
        });

        l10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Home.this,Sandle.class);
                startActivity(intent);
            }
        });


        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Snackbar.make (view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction ("Action", null).show ();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById (R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle (
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener (toggle);
        toggle.syncState ();

        NavigationView navigationView = (NavigationView) findViewById (R.id.nav_view);
        navigationView.setNavigationItemSelectedListener (this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById (R.id.drawer_layout);
        if (drawer.isDrawerOpen (GravityCompat.START)) {
            drawer.closeDrawer (GravityCompat.START);
        } else {
            super.onBackPressed ();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ().inflate (R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            Intent intent=new Intent(Home.this,MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected (item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId ();

        if (id == R.id.nav_contact) {
            Intent j = new Intent(Home.this,Contact_us.class);
            startActivity(j);
            // Handle the camera action
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_Ad)
        {
           Intent I=new Intent(Home.this,MyAccount.class);
           startActivity(I);

        } else if (id == R.id.nav_Myorder)
        {
            Intent i=new Intent(Home.this,MyOrders.class);
            startActivity(i);

        } else if (id == R.id.nav_stores) {
            Intent i=new Intent(Home.this,Stores.class);
            startActivity(i);

        }
        else if (id == R.id.nav_noti ) {
            Intent i=new Intent(Home.this,Main.class);
            startActivity(i);
        }
        else if (id == R.id.nav_contact ) {
            Intent i=new Intent(Home.this,Contact_us.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById (R.id.drawer_layout);
        drawer.closeDrawer (GravityCompat.START);
        return true;
    }
}

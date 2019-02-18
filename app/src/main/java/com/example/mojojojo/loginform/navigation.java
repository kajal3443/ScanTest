package com.example.mojojojo.loginform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

public class navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    GridView grid1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nevigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        grid1=(GridView)findViewById(R.id.g_catlist);
                String catobj1[]={"CLOTHES","WATCHES","SHOES","ELECTROICS","FOOD","KITCHEN ASSOSARIES","KIDS TOYS","BOOKS"};
        int[]testImage={R.drawable.clothe1,R.drawable.watch2,R.drawable.shoes,R.drawable.electronics,R.drawable.grocerry1,R.drawable.kitchen1,R.drawable.toys,R.drawable.book2};

        My_adapter my_adpt=new My_adapter(navigation.this,R.layout.cat_raw,catobj1,testImage);
        grid1.setAdapter(my_adpt);


       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nevigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent homeobj=new Intent(navigation.this,login.class);
            startActivity(homeobj);
            // Handle the camera action
        } else if (id == R.id.nav_category) {

            Intent categoryobj=new Intent(navigation.this,categeory_list.class);
            startActivity(categoryobj);

        } else if (id == R.id.nav_orders) {


        } else if (id == R.id.nav_wish_list) {

           /* Intent orderobj=new Intent(navigation.this,fragment_1.class);
            startActivity(orderobj);*/

            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            BlankFragment bf1=new BlankFragment();
            ft.add(R.id.list_wish,bf1);
            ft.addToBackStack(null);
            ft.commit();


        } else if (id == R.id.nav_account) {

        } else if (id == R.id.nav_settings) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

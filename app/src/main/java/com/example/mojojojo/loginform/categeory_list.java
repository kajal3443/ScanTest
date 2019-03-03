package com.example.mojojojo.loginform;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mojojojo.loginform.database_call.NetworkCall;
import com.example.mojojojo.loginform.database_call.jsn;
import com.example.mojojojo.loginform.model.Product;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class categeory_list extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    GridView grid1;
    ImageView img1;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor shaerdpre;

    TextView textView;
    TextView textViewemail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categeory_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        View headerView = navigationView.getHeaderView(0);
        textView = headerView.findViewById(R.id.username);
        textViewemail = headerView.findViewById(R.id.useremail);

        getUserName();

        // ci=(CircleImageView)findViewById(R.id.cmenimg);
        grid1 = (GridView) findViewById(R.id.g_catlist);

        String catobj1[] = {"CLOTHES", "SHOES","WATCHES" , "ELECTROICS", "KIDS TOYS", "BOOKS"};
        int[] testImage = {R.drawable.clothe1, R.drawable.categoryshoes, R.drawable.watch2, R.drawable.electronics, R.drawable.toys, R.drawable.books1};

        My_adapter my_adpt = new My_adapter(this, R.layout.cat_raw, catobj1, testImage);
        grid1.setAdapter(my_adpt);

        grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int pos, long l) {

                final int i = pos + 1;

                if (i == 1 || i == 2 || i == 3) {

                    Dialog dialog = new Dialog(categeory_list.this);
                    dialog.setContentView(R.layout.cloth_dialog1);
                    dialog.setTitle("Sub Category");
                    ImageView ln = (ImageView) dialog.findViewById(R.id.cmenimg);
                    System.out.println("ln ln ln :>" + ln);
                    ln.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String sub = i + "1";
                            showProductList(sub);
                        }
                    });
                    dialog.show();

                    ImageView wmn = (ImageView) dialog.findViewById(R.id.cwmenimg);
                    System.out.println("wmn wmn wmn :>" + wmn);
                    wmn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String sub = i + "2";
                            showProductList(sub);
                        }
                    });
                    dialog.show();

                    ImageView kid = (ImageView) dialog.findViewById(R.id.ckidimg);
                    kid.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String sub = i + "3";
                            showProductList(sub);
                        }
                    });
                    dialog.show();
                } else {
                    showProductList(String.valueOf(i));

                }

            }

        });

    }

    private void getUserName() {

        sharedPreferences = getSharedPreferences("user information"
                , MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "");

        if (email.equals("")) {
            return;
        }

        HashMap<String, String> param = new HashMap<>();
        param.put("type", "select");
        param.put("table", "subscriber");
        String whereString = "Subscribe_email='" + email + "'";
        param.put("where", whereString);


        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)) {

                    JSONArray jsonArray = jsn.getJSONArrayMessage(responseStr);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsn.getJSONObject(jsonArray, i);

                        textView.setText(jsn.getJSONString(jsonObject, "Subscribe_name"));
                        textViewemail.setText(jsn.getJSONString(jsonObject, "Subscribe_email"));
                    }
                }
            }
        });
    }

    private void showProductList(String subCaegoryPosition) {
        Intent i1 = new Intent(categeory_list.this, ProductListActivity.class);
        i1.putExtra("sub_key", subCaegoryPosition);
        startActivity(i1);

    }

    /* drawer code*/
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
            Intent homeobj = new Intent(this, login.class);
            startActivity(homeobj);
            // Handle the camera action
        } else if (id == R.id.nav_category) {

            Intent categoryobj = new Intent(this, categeory_list.class);
            startActivity(categoryobj);

        } else if (id == R.id.nav_orders) {


        } else if (id == R.id.nav_wish_list) {

           /* Intent orderobj=new Intent(navigation.this,fragment_1.class);
            startActivity(orderobj);*/

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            BlankFragment bf1 = new BlankFragment();
            ft.add(R.id.list_wish, bf1);
            ft.addToBackStack(null);
            ft.commit();


        } else if (id == R.id.nav_account) {
            Intent mycart = new Intent(this, Cartlist.class);
            startActivity(mycart);


        } else if (id == R.id.nav_settings) {
            SharedPreferences sharedPreferences;
            SharedPreferences.Editor shaerdpre;
            sharedPreferences = getSharedPreferences("user information"
                    , MODE_PRIVATE);
            shaerdpre = sharedPreferences.edit();
            shaerdpre.putString("email", "");
            shaerdpre.apply();

            // MyParam.listCart.add(product);
            Intent signout = new Intent(categeory_list.this, login.class);
            startActivity(signout);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}



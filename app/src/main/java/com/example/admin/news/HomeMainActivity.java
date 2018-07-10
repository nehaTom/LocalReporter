package com.example.admin.news;

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
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    GridView androidGridView;
    DrawerLayout drawer;
    ImageView menuBtn;




    String[] gridViewString = {"Top STORIES", "LATEST", "TECNOLOGY", "SPORTS", "CRIME", "ENTERTAINMENT"} ;
    int[] gridViewImageId = {
            R.drawable.top_stories, R.drawable.latestnews, R.drawable.technology, R.drawable.sports, R.drawable.crime, R.drawable.entertainment,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setMenuOnclickListner();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        setGridData();
    }
    public void setMenuOnclickListner(){
        menuBtn = findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appBar();
            }
        });
    }
    public void appBar(){
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);
        }
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }
    public void setGridData(){
        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(HomeMainActivity.this, gridViewString, gridViewImageId);
        androidGridView=(GridView)findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                Toast.makeText(HomeMainActivity.this, "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();
            }
        });
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
Intent i;
        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.language) {

        } else if (id == R.id.services) {

        } else if (id == R.id.setting) {

        } else if (id == R.id.news) {

        }
        else if (id == R.id.faq) {

        }
        else if (id == R.id.login) {

        }
        else if (id == R.id.contact_us) {
            i = new Intent(HomeMainActivity.this,Contact_Us.class);
            startActivity(i);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

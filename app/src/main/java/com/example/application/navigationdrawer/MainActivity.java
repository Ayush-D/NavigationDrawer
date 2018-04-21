package com.example.application.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        displayScreen(item.getItemId());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void displayScreen(int id){

        if(id == R.id.reqtopic){
            Intent i = new Intent(this,RequestActivity.class);
            startActivity(i);
        } else if(id == R.id.bookmarks){
            Intent i = new Intent(this,BookmarksActivity.class);
            startActivity(i);
        } else if(id == R.id.homes){
            //Go to home activity As required I am Making this as activity or shubam can make this as home activity
            //Intent i = new Intent(this,Home.class);
            //startActivity(i);

        } else if(id == R.id.nav_share){

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            //String would be set later
            String sb = "Hi, I am using the Trade Brain Blogger App. I like this and I want you to check it out." +
                    "https://play.google.com/store/apps/details?id=" + this.getPackageName();
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Share via");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, sb);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        } else if(id == R.id.rateus){
            //rate on the App page in Play Store Page using provided link
        } else if(id == R.id.feedback){
            Intent i = new Intent(this,FeedbackActivity.class);
            startActivity(i);
        } else if(id == R.id.nav_about){
            Intent i = new Intent(this,AboutActivity.class);
            startActivity(i);
        } else if(id == R.id.logout){
            //Perform the logout function from FireBase
        }

    }
}

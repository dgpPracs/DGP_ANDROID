package com.example.ferch.museo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class BasicActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected SharedPreferences sharedPreferences;

    protected void añadirBarra(int actualLayout, String title){
        setContentView(actualLayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle(title);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_setting:
                Intent btnIntent = new Intent (this, FirstSettings.class);
                startActivity(btnIntent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        //mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //mDrawerToggle.onConfigurationChanged(newConfig);
    }

    protected void setTitle(String title){

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setText(title);
    }

    protected void showMessage(String string){

        Context context = getApplicationContext();
        CharSequence text = string;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    protected void setLanguage(){

        sharedPreferences = getSharedPreferences("VALUES",MODE_PRIVATE);
        int lang = sharedPreferences.getInt("LANG",2);

        switch (lang){
            case 0: setLocale("fr");
                break;
            case 1: setLocale("de");
                break;
            case 2: setLocale("it");
                break;
            case 3: setLocale("en");
                break;
            case 4: setLocale("es");
                break;
        }
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, this.getClass());
        startActivity(refresh);
        finish();
    }

    protected void factory(){


    }
}

package com.example.ferch.museo;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.ferch.museo.R.id.swchFeatures;
import static com.example.ferch.museo.R.id.swchLanguage;

public class WaitingActivity extends BasicActivity {

    private ImageView signalIcon;
    private TextView text1;
    private TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);
        super.añadirBarra(R.layout.activity_waiting, "MUSEO CAJA GRANADA");

        signalIcon  = (ImageView) findViewById(R.id.waiting_icon);
        text1 = (TextView) findViewById(R.id.waiting_message);
        text2 = (TextView) findViewById(R.id.symbol_description);

        setListeners();

    }

    // Click listener method for button
    void setListeners() {
        // ClickListener for NEXT button
        signalIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent btnIntent = new Intent (WaitingActivity.this, ZoneRecycler.class);
                btnIntent.putExtra("zone", getResources().getString(R.string.zone1));
                btnIntent.putExtra("index", "1");
                startActivity(btnIntent);
            }
        });
        text1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent btnIntent = new Intent (WaitingActivity.this, ZoneRecycler.class);
                btnIntent.putExtra("zone", getResources().getString(R.string.zone2));
                btnIntent.putExtra("index", "2");
                startActivity(btnIntent);
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent btnIntent = new Intent (WaitingActivity.this, ZoneRecycler.class);
                btnIntent.putExtra("zone", getResources().getString(R.string.zone3));
                btnIntent.putExtra("index", "3");
                startActivity(btnIntent);
            }
        });
    }
    
}


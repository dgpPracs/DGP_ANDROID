package com.example.ferch.museo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Principal extends BasicActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.añadirBarra(R.layout.activity_principal);

        this.firstRun();

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);

        //--- BOTON QUE REDIRECCIONA A OTRA ACTIVIDAD--//
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnIntent = new Intent (Principal.this, FirstSettings.class);
                startActivity(btnIntent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnIntent2 = new Intent (Principal.this, ZoneActivity.class);
                startActivity(btnIntent2);
            }
        });

        //---END BOTON---//
    }

    private void firstRun(){

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        //para ver si se ha ejecutado por primera vez o no y mostrar esta activity o mostrar la del tutorial
        if (isFirstRun) {
            //show start activity

            startActivity(new Intent(Principal.this, FirstSettings.class));
            super.showMessage("first run");
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).apply();
    }
}

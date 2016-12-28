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

        /*
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnIntent2 = new Intent (Principal.this, ZoneActivity.class);
                startActivity(btnIntent2);
            }
        });*/

        //---END BOTON---//
    }
}

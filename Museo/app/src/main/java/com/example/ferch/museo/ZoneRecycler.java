package com.example.ferch.museo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ZoneRecycler extends BasicActivity {

    private List<Panel> panels;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone_recycler);
        super.añadirBarra(R.layout.activity_zone_recycler);

        rv=(RecyclerView)findViewById(R.id.zone_rec_view);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        panels = new ArrayList<>();
        panels.add(new Panel("Inicio de la II Guerra Mundial", "Año 19XX", R.drawable.inicio_ii_guerra));
        panels.add(new Panel("Bombas nucleares", "Hiroshima y Nagasaki", R.drawable.nagasaki_bomb));
        panels.add(new Panel("Final de II Guerra Mundial", "19XX", R.drawable.end_world_war));
    }

    private void initializeAdapter(){
        ZoneRecyclerAdapter adapter = new ZoneRecyclerAdapter(panels);
        rv.setAdapter(adapter);
    }
}

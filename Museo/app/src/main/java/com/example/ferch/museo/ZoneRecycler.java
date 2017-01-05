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
        panels.add(new Panel("Lavery Maiss", "25 years old", R.drawable.ic_signal));
        panels.add(new Panel("Emma Wilson", "23 years old", R.drawable.ic_arrow_left));
        panels.add(new Panel("Lillie Watts", "35 years old", R.drawable.ic_signal));
    }

    private void initializeAdapter(){
        ZoneRecyclerAdapter adapter = new ZoneRecyclerAdapter(panels);
        rv.setAdapter(adapter);
    }
}

package com.example.ferch.museo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.path;

public class ZoneRecycler extends BasicActivity {

    private List<Panel> panels;
    private RecyclerView rv;
    private String zoneTitle;
    private String zoneIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone_recycler);
        zoneTitle = getIntent().getExtras().getString("zone");
        zoneIndex = getIntent().getExtras().getString("index");
        super.añadirBarra(R.layout.activity_zone_recycler, zoneTitle);

        rv=(RecyclerView)findViewById(R.id.zone_rec_view);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        panels = new ArrayList<>();
        switch (zoneIndex){
            case "1":
                panels.add(new Panel(getResources().getString(R.string.title1_1), getResources().getString(R.string.subtitle1_1), getResources().getString(R.string.description1_1), R.drawable.inicio_ii_guerra, 1, 1));
                panels.add(new Panel(getResources().getString(R.string.title1_2), getResources().getString(R.string.subtitle1_2), getResources().getString(R.string.description1_2),R.drawable.inicio_ii_guerra, 1, 2));
                break;
            case "2":
                panels.add(new Panel(getResources().getString(R.string.title2_1), getResources().getString(R.string.subtitle2_1), getResources().getString(R.string.description2_1), R.drawable.inicio_ii_guerra, 2, 1));
                break;
            case "3":
                panels.add(new Panel(getResources().getString(R.string.title3_1), getResources().getString(R.string.subtitle3_1), getResources().getString(R.string.description3_1), R.drawable.inicio_ii_guerra, 3, 1));
                break;
            default:
                break;
        }
    }

    private void initializeAdapter(){
        ZoneRecyclerAdapter adapter = new ZoneRecyclerAdapter(panels);
        rv.setAdapter(adapter);
    }
}

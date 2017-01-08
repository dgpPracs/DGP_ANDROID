package com.example.ferch.museo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.path;

public class PanelRecycler extends BasicActivity {

    private List<MultimediaContent> multimediaList;
    private RecyclerView rv;
    private TextView title;
    private TextView subtitle;
    private TextView description;
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_recycler);

        super.añadirBarra(R.layout.activity_panel_recycler);

        rv=(RecyclerView)findViewById(R.id.panel_rec_view);
        title=(TextView) findViewById(R.id.title);
        subtitle=(TextView)findViewById(R.id.sub_title);
        description=(TextView)findViewById(R.id.description);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        title.setText("Título del Panel");
        subtitle.setText("Sub Título del Panel");
        description.setText("Description 11..... \n Me mueeeroooo :( \n criii .. :(");
        multimediaList = new ArrayList<MultimediaContent>();
        multimediaList.add(new MultimediaContent("android.resource://"+getPackageName()+"/"+R.raw.shortvideo, "video"));
        multimediaList.add(new MultimediaContent("android.resource://"+getPackageName()+"/"+R.raw.test_song, "audio"));
    }


    private void initializeAdapter(){
        PanelRecyclerAdapter adapter = new PanelRecyclerAdapter(multimediaList);
        rv.setAdapter(adapter);
    }

}

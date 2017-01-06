package com.example.ferch.museo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PanelRecycler extends BasicActivity {

    private List<MultimediaContent> multimediaList;
    private RecyclerView rv;
    private TextView title;
    private TextView subtitle;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_recycler);

        super.añadirBarra(R.layout.activity_zone_recycler);

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
        description.setText("Description 11..... Me mueeeroooo :(");
        multimediaList = new ArrayList<>();
        multimediaList.add(new MultimediaContent(R.raw.video_gestual));
        multimediaList.add(new MultimediaContent(R.raw.video_gestual));
    }

    private void initializeAdapter(){
        PanelRecyclerAdapter adapter = new PanelRecyclerAdapter(multimediaList);
        rv.setAdapter(adapter);
    }


}

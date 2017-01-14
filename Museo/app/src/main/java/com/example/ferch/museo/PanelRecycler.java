package com.example.ferch.museo;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.path;
import static android.R.attr.subtitle;
import static android.R.attr.subtitleTextAppearance;

public class PanelRecycler extends BasicActivity {

    private List<MultimediaContent> multimediaList;
    private RecyclerView rv;
    private TextView titleView;
    private TextView subtitleView;
    private TextView descriptionView;
    private VideoView video;
    private ImageView panelImageDet;
    private String title;
    private String subTitle;
    private String description;
    private int zoneId;
    private int panelId;
    private int imageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_recycler);
        zoneId = getIntent().getExtras().getInt("zoneId");
        panelId = getIntent().getExtras().getInt("panelId");
        title = getIntent().getExtras().getString("title");
        subTitle = getIntent().getExtras().getString("subTitle");
        description = getIntent().getExtras().getString("description");
        imageId = getIntent().getExtras().getInt("imageId");

        super.añadirBarra(R.layout.activity_panel_recycler, "zone"+zoneId);

        rv=(RecyclerView)findViewById(R.id.panel_rec_view);
        titleView=(TextView) findViewById(R.id.title);
        subtitleView=(TextView)findViewById(R.id.sub_title);
        descriptionView=(TextView)findViewById(R.id.description);
        panelImageDet = (ImageView) findViewById(R.id.panel_image_det);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        panelImageDet.setImageResource(imageId);
        titleView.setText(title);
        subtitleView.setText(subTitle);
        descriptionView.setText(description);
        multimediaList = new ArrayList<MultimediaContent>();
        multimediaList.add(new MultimediaContent("android.resource://"+getPackageName()+"/"+R.raw.test, "video", "Evento detallado mediante lenguaje de signos"));
        multimediaList.add(new MultimediaContent("android.resource://"+getPackageName()+"/"+R.raw.test_song, "audio", "Narración de los detalles del evento"));
    }

    private void initializeAdapter(){
        PanelRecyclerAdapter adapter = new PanelRecyclerAdapter(multimediaList);
        rv.setAdapter(adapter);
    }

}

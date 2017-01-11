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

public class PanelRecycler extends BasicActivity {

    private List<MultimediaContent> multimediaList;
    private RecyclerView rv;
    private TextView title;
    private TextView subtitle;
    private TextView description;
    private VideoView video;
    ImageView panelImageDet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_recycler);

        super.añadirBarra(R.layout.activity_panel_recycler);

        rv=(RecyclerView)findViewById(R.id.panel_rec_view);
        title=(TextView) findViewById(R.id.title);
        subtitle=(TextView)findViewById(R.id.sub_title);
        description=(TextView)findViewById(R.id.description);
        panelImageDet = (ImageView) findViewById(R.id.panel_image_det);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        panelImageDet.setImageResource(R.drawable.inicio_ii_guerra);
        title.setText("Bombas nnucleares");
        subtitle.setText("Hiroshima y Nagasaki");
        description.setText("Los bombardeos atómicos sobre Hiroshima y Nagasaki fueron ataques nucleares ordenados por Harry S. Truman, presidente de los Estados Unidos, contra el Imperio del Japón. Los ataques se efectuaron el 6 y el 9 de agosto de 1945 respectivamente, lo que forzó la rendición de Japón y el fin de la Segunda Guerra Mundial.");
        multimediaList = new ArrayList<MultimediaContent>();
        multimediaList.add(new MultimediaContent("android.resource://"+getPackageName()+"/"+R.raw.test, "video", "Evento detallado mediante lenguaje de signos"));
        multimediaList.add(new MultimediaContent("android.resource://"+getPackageName()+"/"+R.raw.test_song, "audio", "Narración de los detalles del evento"));
    }

    private void initializeAdapter(){
        PanelRecyclerAdapter adapter = new PanelRecyclerAdapter(multimediaList);
        rv.setAdapter(adapter);
    }

}

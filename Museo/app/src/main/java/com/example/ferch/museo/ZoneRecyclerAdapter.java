package com.example.ferch.museo;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.example.ferch.museo.R.id.btn1;
import static com.example.ferch.museo.R.id.panelCV;

/**
 * Created by Luna on 04/01/2017.
 */

public class ZoneRecyclerAdapter extends RecyclerView.Adapter<ZoneRecyclerAdapter.PanelViewHolder>{

    public static class PanelViewHolder extends RecyclerView.ViewHolder {

        CardView panelCV;
        TextView panelTitle;
        TextView panelSubTitle;
        ImageView panelImage;

        PanelViewHolder(View itemView) {
            super(itemView);
            panelCV = (CardView)itemView.findViewById(R.id.panelCV);
            panelImage = (ImageView)itemView.findViewById(R.id.panel_image);
            panelTitle = (TextView)itemView.findViewById(R.id.panel_title);
            panelSubTitle = (TextView)itemView.findViewById(R.id.panel_sub_title);
        }

    }

    List<Panel> panels;

    ZoneRecyclerAdapter(List<Panel> panels){
        this.panels = panels;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PanelViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.panel_template, viewGroup, false);
        PanelViewHolder pvh = new PanelViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PanelViewHolder panelViewHolder, int i) {
        panelViewHolder.panelTitle.setText(panels.get(i).title);
        panelViewHolder.panelSubTitle.setText(panels.get(i).subTitle);
        panelViewHolder.panelImage.setImageResource(panels.get(i).imageId);

        //--- BOTON QUE REDIRECCIONA A OTRA ACTIVIDAD--//
        panelViewHolder.panelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent btnIntent = new Intent(ZoneRecyclerAdapter.this, FirstSettings.class);
                //startActivity(btnIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return panels.size();
    }

}

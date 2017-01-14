package com.example.ferch.museo;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.ClipData.Item;

import java.util.List;

import static com.example.ferch.museo.R.id.activity_basic;
//import static com.example.ferch.museo.R.id.btn1;
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
        View v;
        Panel currentPanel;

        PanelViewHolder(View itemView) {
            super(itemView);
            v=itemView;
            panelCV = (CardView)itemView.findViewById(R.id.panelCV);
            panelImage = (ImageView)itemView.findViewById(R.id.panel_image);
            panelTitle = (TextView)itemView.findViewById(R.id.panel_title);
            panelSubTitle = (TextView)itemView.findViewById(R.id.panel_sub_title);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent btnIntent = new Intent(v.getContext(), PanelRecycler.class);
                    btnIntent.putExtra("zoneId", currentPanel.zoneId);
                    btnIntent.putExtra("panelId", currentPanel.panelId);
                    btnIntent.putExtra("title", currentPanel.title);
                    btnIntent.putExtra("subTitle", currentPanel.subTitle);
                    btnIntent.putExtra("description", currentPanel.description);
                    btnIntent.putExtra("imageId", currentPanel.imageId);
                    v.getContext().startActivity(btnIntent);
                }
            });
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
        panelViewHolder.currentPanel = panels.get(i);
    }

    @Override
    public int getItemCount() {
        return panels.size();
    }

}

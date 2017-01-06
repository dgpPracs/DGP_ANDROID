package com.example.ferch.museo;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.List;

/**
 * Created by Luna on 06/01/2017.
 */

public class PanelRecyclerAdapter extends RecyclerView.Adapter<PanelRecyclerAdapter.MultimediaViewHolder> {

    public static class MultimediaViewHolder extends RecyclerView.ViewHolder {

        CardView panelCV;
        VideoView video;
        View v;
        MultimediaContent currentMult;

        MultimediaViewHolder(View itemView) {
            super(itemView);
            v=itemView;
            panelCV = (CardView)itemView.findViewById(R.id.panelCV);
            //video = (Video)itemView.findViewById(R.id.panel_image);
        }

    }

    List<MultimediaContent> multimediaList;

    PanelRecyclerAdapter(List<MultimediaContent> multimediaList){
        this.multimediaList = multimediaList;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PanelRecyclerAdapter.MultimediaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.multimedia_template, viewGroup, false);
        PanelRecyclerAdapter.MultimediaViewHolder pvh = new PanelRecyclerAdapter.MultimediaViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PanelRecyclerAdapter.MultimediaViewHolder multimediaViewHolder, int i) {
        Uri path = Uri.parse("android.resource://com.example.ferch.museo/" + R.raw.video_gestual);
        //Uri path = Uri.parse(R.raw.video_gestual));
        multimediaViewHolder.video.setVideoURI(path);
        multimediaViewHolder.video.start();
        multimediaViewHolder.currentMult = multimediaList.get(i);
    }

    @Override
    public int getItemCount() {
        return multimediaList.size();
    }

}

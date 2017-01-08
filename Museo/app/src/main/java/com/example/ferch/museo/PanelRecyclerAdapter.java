package com.example.ferch.museo;

import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.net.URI;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Luna on 06/01/2017.
 */

public class PanelRecyclerAdapter extends RecyclerView.Adapter<PanelRecyclerAdapter.MultimediaViewHolder> {

    public static class MultimediaViewHolder extends RecyclerView.ViewHolder {

        CardView panelCV;
        VideoView video;
        View v;
        MultimediaContent currentMult;
        LinearLayout multimediaLayout;
        ViewGroup.LayoutParams params;

        MultimediaViewHolder(View itemView) {
            super(itemView);
            v=itemView;
            panelCV = (CardView)itemView.findViewById(R.id.panelCV);
            video = (VideoView)itemView.findViewById(R.id.video_multimedia);
            multimediaLayout = (LinearLayout) itemView.findViewById(R.id.multimedia_layout);
            params = multimediaLayout.getLayoutParams();
        }
    }

    List<MultimediaContent> multimediaList;
    String type;

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
        this.type=multimediaList.get(i).type;
        if(type=="audio"){
            //multimediaViewHolder.video.setVisibility(View.GONE);
            //MediaPlayer mediaPlayer;
            //mediaPlayer = MediaPlayer.create(multimediaViewHolder.v.getContext(), R.raw.test_song);
            multimediaViewHolder.params.height = 60;
            multimediaViewHolder.multimediaLayout.setLayoutParams(multimediaViewHolder.params);
            setVideo(multimediaViewHolder, i);
        }else{
            multimediaViewHolder.params.height = 250;
            multimediaViewHolder.multimediaLayout.setLayoutParams(multimediaViewHolder.params);
            //multimediaViewHolder.video.setVisibility(View.VISIBLE);
            setVideo(multimediaViewHolder, i);
        }
        multimediaViewHolder.currentMult = multimediaList.get(i);
    }

    public void setVideo(PanelRecyclerAdapter.MultimediaViewHolder multimediaViewHolder, int i){
        multimediaViewHolder.video.setVideoURI(multimediaList.get(i).multimediaUri);
        multimediaViewHolder.video.setZOrderOnTop(true);
        MediaController mc = new MediaController(multimediaViewHolder.v.getContext()) {
            @Override
            public void hide() {
                this.show();
                this.show(0);
            }
            @Override
            public void setMediaPlayer(MediaPlayerControl player) {
                super.setMediaPlayer(player);
                this.show();
                this.show(0);
            }
        };
        multimediaViewHolder.video.setMediaController(mc);
        multimediaViewHolder.video.start();
        mc.show();
        mc.setBackgroundColor(multimediaViewHolder.v.getResources().getColor(R.color.colorPrimaryDark));
        mc.setDrawingCacheBackgroundColor(multimediaViewHolder.v.getResources().getColor(R.color.colorPrimaryDark));
        mc.show(0);
        mc.show(50000);

    }

    @Override
    public int getItemCount() {
        return multimediaList.size();
    }

}

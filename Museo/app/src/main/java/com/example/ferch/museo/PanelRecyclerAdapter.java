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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.net.URI;
import java.util.List;
import java.util.*;

import static android.R.attr.button;
import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Luna on 06/01/2017.
 */

public class PanelRecyclerAdapter extends RecyclerView.Adapter<PanelRecyclerAdapter.MultimediaViewHolder> {

    public static class MultimediaViewHolder extends RecyclerView.ViewHolder {

        CardView panelCV;
//        VideoView video;
        View v;
        MultimediaContent currentMult;
        ImageView multImage;
        TextView multDescription;
        TextView multLenght;
        Button btnPlay;
        //LinearLayout multimediaLayout;
//        ViewGroup.LayoutParams params;

        MultimediaViewHolder(View itemView) {
            super(itemView);
            v=itemView;
            panelCV = (CardView)itemView.findViewById(R.id.panelCV);
            multImage = (ImageView)itemView.findViewById(R.id.multimedia_image);
            multDescription = (TextView)itemView.findViewById(R.id.multimedia_description);
            multLenght = (TextView)itemView.findViewById(R.id.multimedia_lenght);
            btnPlay = (Button) itemView.findViewById(R.id.btnPlay);
//            video = (VideoView)itemView.findViewById(R.id.video_multimedia);
//            multimediaLayout = (LinearLayout) itemView.findViewById(R.id.multimedia_layout);
//            params = multimediaLayout.getLayoutParams();

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
            multimediaViewHolder.multImage.setImageResource(R.drawable.audio_icon);
//            multimediaViewHolder.btnPlay.setText(R.string.playAudio);
            multimediaViewHolder.btnPlay.setText("Escuchar");
//            multimediaViewHolder.params.height = 100;
//            multimediaViewHolder.multimediaLayout.setLayoutParams(multimediaViewHolder.params);
//            setVideo(multimediaViewHolder, i);
        }else{
            multimediaViewHolder.multImage.setImageResource(R.drawable.video_icon);
            multimediaViewHolder.btnPlay.setText(R.string.playVideo);
//            multimediaViewHolder.params.height = 350;
//            multimediaViewHolder.multimediaLayout.setLayoutParams(multimediaViewHolder.params);
//            multimediaViewHolder.video.setVisibility(View.VISIBLE);
//            setVideo(multimediaViewHolder, i);
        }
        multimediaViewHolder.multDescription.setText(multimediaList.get(i).description);
        MediaPlayer mediaPlayer = MediaPlayer.create(multimediaViewHolder.v.getContext(), multimediaList.get(i).multimediaUri);
        String duration = milliSecondsToTimer(mediaPlayer.getDuration());
        multimediaViewHolder.multLenght.setText( duration );
        multimediaViewHolder.currentMult = multimediaList.get(i);
    }

    /*public void setVideo(PanelRecyclerAdapter.MultimediaViewHolder multimediaViewHolder, int i){
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
                //this.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                //this.setDrawingCacheBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        };
        multimediaViewHolder.video.setMediaController(mc);
        multimediaViewHolder.video.start();
        multimediaViewHolder.video.stopPlayback();
        multimediaViewHolder.video.setPadding(0, 0, 0, 50);
        mc.show(50000);
        mc.setPadding(0, 50, 0, 0);
    }*/

    @Override
    public int getItemCount() {
        return multimediaList.size();
    }

    public String milliSecondsToTimer(long milliseconds){
        String finalTimerString = "";
        String secondsString = "";
        // Convert total duration into time
        int hours = (int)( milliseconds / (1000*60*60));
        int minutes = (int)(milliseconds % (1000*60*60)) / (1000*60);
        int seconds = (int) ((milliseconds % (1000*60*60)) % (1000*60) / 1000);
        // Add hours if there
        if(hours > 0){
            finalTimerString = hours + ":";
        }
        // Prepending 0 to seconds if it is one digit
        if(seconds < 10){
            secondsString = "0" + seconds;
        }else{
            secondsString = "" + seconds;}
        finalTimerString = finalTimerString + minutes + ":" + secondsString;
        // return timer string
        return finalTimerString;
    }

}

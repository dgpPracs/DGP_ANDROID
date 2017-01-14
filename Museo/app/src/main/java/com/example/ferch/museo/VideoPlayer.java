package com.example.ferch.museo;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import static java.security.AccessController.getContext;

public class VideoPlayer extends AppCompatActivity {

    VideoView video;
    String path;
    Uri uri;
    String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //Traer datos del video
        path = getIntent().getExtras().getString("path");
        uri = Uri.parse(path);
        description = getIntent().getExtras().getString("description");
        //Set video
        video = (VideoView) findViewById(R.id.video_player);
        video.setZOrderOnTop(true);
        video.setVideoURI(uri);
//        MediaController mc = new MediaController(this.getApplicationContext()) {
//            @Override
//            public void hide() {
//                this.show();
//                this.show(0);
//            }
//            @Override
//            public void setMediaPlayer(MediaPlayerControl player) {
//                super.setMediaPlayer(player);
//                this.show();
//                this.show(0);
//            }
//        };
        MediaController mc = new MediaController(this);
        video.setMediaController(mc);
        //video.requestFocus();
        video.start();

    }
}

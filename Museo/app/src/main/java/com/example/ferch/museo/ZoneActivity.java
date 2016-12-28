package com.example.ferch.museo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class ZoneActivity extends BasicActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone);
        super.añadirBarra(R.layout.activity_zone);

        video =(VideoView)findViewById(R.id.video_multimedia);
        //de forma alternativa si queremos un streaming usar
        //mVideoView.setVideoURI(Uri.parse(URLstring));
        Uri path = Uri.parse("android.resource://com.example.reproducirvideo/"
                + R.raw.video_gestual);
        video.setVideoURI(path);
        video.start();
    }


}

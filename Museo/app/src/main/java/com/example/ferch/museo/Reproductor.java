package com.example.ferch.museo;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by ferch on 15/01/2017.
 */

public class Reproductor {

    private static MediaPlayer player;



    public static void play (Context context, int id){
        player = MediaPlayer.create(context, id);
        player.setLooping(true);   player.start();
    }

    public static void stop (Context context){
        if(player != null){
            player.stop();
            player.release();
            player = null;
        }
    }
}

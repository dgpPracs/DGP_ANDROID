package com.example.ferch.museo;

import android.net.Uri;

import java.net.URI;

/**
 * Created by Luna on 06/01/2017.
 */

public class MultimediaContent {

    Uri multimediaUri;
    String type;
    String description;

    MultimediaContent(String multimediaPath, String type, String description) {
        Uri uri = Uri.parse(multimediaPath);
        this.multimediaUri = uri;
        this.type=type;
        this.description = description;
    }

}

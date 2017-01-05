package com.example.ferch.museo;

import static android.R.attr.name;

/**
 * Created by Luna on 04/01/2017.
 */

public class Panel {

    String title;
    String subTitle;
    int imageId;

    Panel(String title, String subTitle, int imageId) {
        this.title = title;
        this.subTitle = subTitle;
        this.imageId = imageId;
    }

}

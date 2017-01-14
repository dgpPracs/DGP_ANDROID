package com.example.ferch.museo;

import static android.R.attr.name;

/**
 * Created by Luna on 04/01/2017.
 */

public class Panel {

    String title;
    String subTitle;
    String description;
    int imageId;
    int zoneId;
    int panelId;

    Panel(String title, String subTitle, String description, int imageId, int zoneId, int panelId) {
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.imageId = imageId;
        this.zoneId = zoneId;
        this.panelId = panelId;
    }

}

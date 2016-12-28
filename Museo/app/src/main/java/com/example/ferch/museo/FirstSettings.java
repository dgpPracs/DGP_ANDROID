package com.example.ferch.museo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;


public class FirstSettings extends BasicActivity {

    private static ImageButton nextLang;
    private static ImageButton prevLang;
    private static TextSwitcher swchLanguage;
    private static ImageButton nextFeat;
    private static ImageButton prevFeat;
    private static TextSwitcher swchFeatures;
    private static Button btnGo;

    // ********** LANGUAGES ***********
    // String array to be shown on textSwitcher
    String languages[] = { "Español", "English",
            "Alemán", "Francés", "Italiano" };
    // Total length of the string array
    int cantLanguages = languages.length;
    // to keep current Index of text
    int currentIndexLang = 0;

    // ********** LANGUAGES ***********
    // String array to be shown on textSwitcher
    String features[] = { "Ninguna", "Discapacidad Visual",
            "Discapacidad auditiva", "Adulto mayor"};
    // Total length of the string array
    int cantFeatures = features.length;
    // to keep current Index of text
    int currentIndexFeat = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_settings);
        // Call all the methods
        init();
        loadAnimations("right", swchLanguage);
        loadAnimations("right", swchFeatures);
        setFactory(swchLanguage);
        setFactory(swchFeatures);
        setListener();
        swchLanguage.setText(languages[0]);
        swchFeatures.setText(features[0]);
    }


    void init() {
        nextLang = (ImageButton) findViewById(R.id.btnNextLang);
        prevLang = (ImageButton) findViewById(R.id.btnPrevLang);
        swchLanguage = (TextSwitcher) findViewById(R.id.swchLanguage);
        nextFeat = (ImageButton) findViewById(R.id.btnNextFeat);
        prevFeat = (ImageButton) findViewById(R.id.btnPrevFeat);
        swchFeatures = (TextSwitcher) findViewById(R.id.swchFeatures);
        btnGo = (Button) findViewById(R.id.btnGo);
    }

    void loadAnimations(String orientation, TextSwitcher switcher) {
        Animation in;
        Animation out;
        if(orientation=="right"){
            // Declare the in and out animations and initialize them
            in = AnimationUtils.loadAnimation(this,
                    android.R.anim.slide_in_left);
            out = AnimationUtils.loadAnimation(this,
                    android.R.anim.slide_out_right);
        }else{
            // Declare the in and out animations and initialize them
            in = AnimationUtils.loadAnimation(this,
                    android.R.anim.fade_in);
            out = AnimationUtils.loadAnimation(this,
                    android.R.anim.fade_out);
        }
        // set the animation type of textSwitcher
        switcher.setInAnimation(in);
        switcher.setOutAnimation(out);
    }

    // Click listener method for button
    void setListener() {
        // ClickListener for NEXT button
        nextLang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                loadAnimations("right", swchLanguage);
                currentIndexLang++;
                // If index reaches maximum reset it
                if (currentIndexLang == cantLanguages)
                    currentIndexLang = 0;
                // Set the textSwitcher text according to current index from string array
                swchLanguage.setText(languages[currentIndexLang]);
            }
        });
        // ClickListener for NEXT button
        prevLang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                loadAnimations("left", swchLanguage);
                currentIndexLang--;
                // If index reaches maximum reset it
                if (currentIndexLang < 0)
                    currentIndexLang = cantLanguages-1;
                // Set the textSwitcher text according to current index from string array
                swchLanguage.setText(languages[currentIndexLang]);
            }
        });
        nextFeat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                loadAnimations("right", swchFeatures);
                currentIndexFeat++;
                // If index reaches maximum reset it
                if (currentIndexFeat == cantFeatures)
                    currentIndexFeat = 0;
                // Set the textSwitcher text according to current index from string array
                swchFeatures.setText(features[currentIndexFeat]);
            }
        });
        prevFeat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                loadAnimations("left", swchFeatures);
                currentIndexFeat--;
                // If index reaches maximum reset it
                if (currentIndexFeat < 0)
                    currentIndexFeat = cantFeatures-1;
                // Set the textSwitcher text according to current index from string array
                swchFeatures.setText(features[currentIndexFeat]);
            }
        });
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnIntent = new Intent (FirstSettings.this, WaitingActivity.class);
                startActivity(btnIntent);
            }
        });
    }

    // Set Factory for the textSwitcher *Compulsory part
    void setFactory(TextSwitcher switcher) {
        switcher.setFactory(new ViewFactory() {
            public View makeView() {
                // Create run time textView with some attributes like gravity, color, etc.
                TextView myText = new TextView(FirstSettings.this);
                myText.setGravity(Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(22);
                myText.setTextColor(Color.BLACK);
                return myText;
            }
        });
    }



}

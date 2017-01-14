package com.example.ferch.museo;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class Principal extends BasicActivity{

    SharedPreferences sharedPreferences;

    private static ImageButton nextLang;
    private static ImageButton prevLang;
    private static TextSwitcher swchLanguage;
    private static ImageButton nextFeat;
    private static ImageButton prevFeat;
    private static TextSwitcher swchFeatures;
    private static Button btnGo;

    // ********** LANGUAGES ***********
    // String array to be shown on textSwitcher

    //CharSequence spanish = getResources().getString(R.string.spanish);
    CharSequence languages[] = { "", "",
            "", "","" };
    // Total length of the string array
    int cantLanguages = languages.length;
    // to keep current Index of text
    int currentIndexLang = 0;

    // ********** LANGUAGES ***********
    // String array to be shown on textSwitcher
    CharSequence features[] = { "", "",
            "", ""};
    // Total length of the string array
    int cantFeatures = features.length;
    // to keep current Index of text
    int currentIndexFeat = 0;

    CharSequence[] setLangs(CharSequence languages[]){
        languages[0] = getString(R.string.french);
        languages[1] = getString(R.string.german);
        languages[2] = getString(R.string.italian);
        languages[3] = getString(R.string.english);
        languages[4] = getString(R.string.spanish);
        return languages;
    }

    CharSequence[] setFeats(CharSequence feats[]){
        feats[0] = getString(R.string.nothing);
        feats[1] = getString(R.string.eldery);
        feats[2] = getString(R.string.blind);
        feats[3] = getString(R.string.deaf);
        return feats;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.setLanguage();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //super.añadirBarra(R.layout.activity_principal, "MUSEO CAJA GRANADA");
        this.firstRun();

        sharedPreferences = getSharedPreferences("VALUES",MODE_PRIVATE);
        int lang = sharedPreferences.getInt("LANG",2);
        //showMessage(lang+"");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        // Call all the methods
        init();
        loadAnimations("right", swchLanguage);
        loadAnimations("right", swchFeatures);
        setFactory(swchLanguage);
        setFactory(swchFeatures);
        setListener();

        //metodos para meter los idiomas dentro de cada campo y que lo ponga en el idioma correspondiente
        languages = this.setLangs(languages);
        features = this.setFeats(features);
        swchLanguage.setText(languages[0]);
        swchFeatures.setText(features[0]);
    }

    private void init() {
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
//        if(orientation=="right"){
//            // Declare the in and out animations and initialize them
//            in = AnimationUtils.loadAnimation(this,
//                    android.R.anim.slide_in_left);
//            out = AnimationUtils.loadAnimation(this,
//                    android.R.anim.slide_out_right);
//        }else{
            // Declare the in and out animations and initialize them
            in = AnimationUtils.loadAnimation(this,
                    android.R.anim.fade_in);
            out = AnimationUtils.loadAnimation(this,
                    android.R.anim.fade_out);
//        }
        // set the animation type of textSwitcher
        switcher.setInAnimation(in);
        switcher.setOutAnimation(out);
    }

    private void firstRun(){
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        //para ver si se ha ejecutado por primera vez o no y mostrar esta activity o mostrar la del tutorial
        if (isFirstRun) {
            //show start activity
            startActivity(new Intent(Principal.this, FirstSettings.class));
            super.showMessage("first run");
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).apply();
    }

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
                //selectLang(currentIndexLang);
                Intent btnIntent = new Intent (Principal.this, WaitingActivity.class);
                startActivity(btnIntent);
            }
        });
    }

    void selectLang(int lang){

        switch (lang){

            case 0:
                this.saveLang(0);//frances
                break;
            case 1:
                this.saveLang(1);//aleman
                break;
            case 2:
                this.saveLang(2);//italiano
                break;
            case 3:
                this.saveLang(3);//ingles
                break;
            case 4:
                this.saveLang(4);//español
                break;
        }
    }

    void saveLang(int lang){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("LANG",lang);
        editor.apply();
    }

    // Set Factory for the textSwitcher *Compulsory part
    void setFactory(TextSwitcher switcher) {
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                // Create run time textView with some attributes like gravity, color, etc.
                TextView myText = new TextView(Principal.this);
                myText.setGravity(Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(22);
                myText.setTextColor(Color.BLACK);
                return myText;
            }
        });
    }
}

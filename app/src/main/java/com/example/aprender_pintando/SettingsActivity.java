package com.example.aprender_pintando;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SettingsActivity extends BaseActivity  {


    ImageView screen;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        screen = (ImageView) findViewById(R.id.template_screen);
    }
    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_settings;
    }

    public void setearSonido(View view){
        int sonido = Integer.parseInt(view.getTag().toString());

        if(rSonido != sonido){
            sonidos[rSonido].stop();
            sonidos[sonido].start();
            rSonido = sonido;
        }
    }

    public void setearFondoPantalla(View view){
        int color = Integer.parseInt(view.getTag().toString());
        switch (color){
            case 1:
                screen.setBackgroundColor(Color.parseColor(getString(R.string.screen01)));
                break;
            case 2:
                screen.setBackgroundColor(Color.parseColor(getString(R.string.screen02)));
                break;
            case 3:
                screen.setBackgroundColor(Color.parseColor(getString(R.string.screen03)));
                break;
            case 4:
                screen.setBackgroundColor(Color.parseColor(getString(R.string.screen04)));
               break;
            case 5:
                screen.setBackgroundColor(Color.parseColor(getString(R.string.screen05)));

                break;
            case 6:
                screen.setBackgroundColor(Color.parseColor(getString(R.string.screen06)));

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + color);
        }
    }
}
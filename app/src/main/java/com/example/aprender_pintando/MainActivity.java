package com.example.aprender_pintando;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.aprender_pintando.Domain.Configuracion;
import com.example.aprender_pintando.Controller.ConfiguracionCtrl;
import com.example.aprender_pintando.Controller.LetraCtrl;
import com.example.aprender_pintando.Domain.Letra;

public class MainActivity extends BaseActivity  {

    ConfiguracionCtrl cfgCtrl;
    LetraCtrl lCtrl;
    ConstraintLayout view;
    ImageButton btn_play, btn_continuar, btn_grilla, btn_config;
    int initialPosYButtons = 100;
    int widthAndHeigthButtons = 240;
    int marginButtons = 40;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = findViewById(R.id.main);
        cfgCtrl = new ConfiguracionCtrl(this);
        lCtrl = new LetraCtrl(this);

        int posYButtons = initialPosYButtons;
        btn_play = createButton(1, widthAndHeigthButtons, posYButtons);
        view.addView(btn_play);
        posYButtons = posYButtons + widthAndHeigthButtons + marginButtons;

        if(lCtrl.getLetraPendiente() != null){
            btn_continuar = createButton(2, widthAndHeigthButtons, posYButtons);
            view.addView(btn_continuar);
            posYButtons = posYButtons + (widthAndHeigthButtons + marginButtons);
        }

        btn_grilla = createButton(3, widthAndHeigthButtons, posYButtons);
        view.addView(btn_grilla);
        posYButtons = posYButtons + (widthAndHeigthButtons + marginButtons);

        btn_config = createButton(4, widthAndHeigthButtons, posYButtons);
        view.addView(btn_config);

        Configuracion cfg = cfgCtrl.getConfiguracion();

        cargarSonidos();
        if(cfg.getSonido() != -1){ iniciarSonidoConfig(cfg.getSonido());}
        else { iniciarSonidoAleatorio(); }
    }
    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_main;
    }

    private void iniciarSonidoAleatorio(){

        rSonido = (int) Math.floor(Math.random()*(1-4+1)+4); // Valor entre M y N, ambos incluidos.
        if(!sonidos[rSonido].isPlaying()){
            for (int i = 0; i< 4; i++) {
                if(sonidos[i].isPlaying())
                    sonidos[i].pause();
            }
            sonidos[rSonido].start();
            sonidos[rSonido].setLooping(true);
        }
    }

    private void iniciarSonidoConfig(int sonido){
        if(!sonidos[sonido].isPlaying()){
            for (int i = 0; i< 4; i++) {
                if(sonidos[i].isPlaying())
                    sonidos[i].pause();
            }
            sonidos[sonido].start();
            sonidos[sonido].setLooping(true);
            rSonido = sonido;
        }
    }

    private ImageButton createButton(int btn, int dimension, int posY){
        ImageButton button = new ImageButton(this);
        button.setLayoutParams(new ConstraintLayout.LayoutParams(dimension,dimension));
        button.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Drawable drawable = null;
        switch (btn){
            case 1:
                drawable = getResources().getDrawable( R.drawable.play );
                button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        ComenzarJuego(view);
                    }
                });
                break;
            case 2:
                drawable = getResources().getDrawable( R.drawable.continuar );
                button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        ContinuarJuego(view);
                    }
                });
                break;
            case 3:
                drawable = getResources().getDrawable( R.drawable.grid );
                button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        GrillaProgreso(view);
                    }
                });
                break;
            case 4:
                drawable = getResources().getDrawable( R.drawable.settings );
                button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        ConfigurarJuego(view);
                    }
                });
                break;
        }



        button.setBackground(drawable);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int posX = width / 2 - dimension / 2;
        button.setX(posX);
        button.setY(posY);

        return button;
    }

    public void ComenzarJuego(View view)
    {

        Intent intent = new Intent(view.getContext(), PlayGameActivity.class);
        startActivity(intent);
    }

    public void ContinuarJuego(View view)
    {
        Intent intent = new Intent(view.getContext(), PlayGameActivity.class);
        startActivity(intent);
    }

    public void ConfigurarJuego(View view)
    {
        Intent intent = new Intent(view.getContext(), SettingsActivity.class);
        startActivity(intent);
    }

    public void GrillaProgreso(View view)
    {
        Intent intent = new Intent(view.getContext(), ProgressGridActivity.class);
        startActivity(intent);
    }
}

package com.example.aprender_pintando;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.aprender_pintando.Domain.Configuracion;
import com.example.aprender_pintando.Controller.ConfiguracionCtrl;
import com.example.aprender_pintando.Controller.LetraCtrl;

public class MainActivity extends BaseActivity  {

    ConfiguracionCtrl cfgCtrl;
    LetraCtrl lCtrl;
    ImageButton btn_play, btn_grilla, btn_config;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConstraintLayout view = findViewById(R.id.main);

        btn_play = (ImageButton) findViewById(R.id.btn_play);
        btn_grilla = (ImageButton) findViewById(R.id.btn_grid);
        btn_config = (ImageButton) findViewById(R.id.btn_settings);
        cfgCtrl = new ConfiguracionCtrl(this);
        lCtrl = new LetraCtrl(this);
        Configuracion cfg = cfgCtrl.getConfiguracion();

        /*ImageButton btn_continuar = new ImageButton(this);
        btn_continuar.setMaxHeight(20);
        btn_continuar.setMaxWidth(20);
        btn_continuar.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Drawable drawable = getResources().getDrawable( R.drawable.continuar );
        btn_continuar.setBackground(drawable);
        btn_continuar.setX(0);
        btn_continuar.setY(0);
        view.addView(btn_continuar);*/

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

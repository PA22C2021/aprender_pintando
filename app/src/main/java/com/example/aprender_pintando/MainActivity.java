package com.example.aprender_pintando;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.aprender_pintando.Helper.AdminSQLiteOpenHelper;

public class MainActivity extends BaseActivity  {

    ImageButton btn_play, btn_continuar, btn_grilla, btn_config;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn_play = (ImageButton) findViewById(R.id.btn_play);
        btn_grilla = (ImageButton) findViewById(R.id.btn_grid);AdminSQLiteOpenHelper
        btn_config = (ImageButton) findViewById(R.id.btn_settings);
        AdminSQLiteOpenHelper db = new (this, "aprender_pintando", null , 1);
        Log.d("db ------ " , db.toString());

        iniciarSonidoAleatorio();
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
                    sonidos[i].stop();
            }
            sonidos[rSonido].start();
            sonidos[rSonido].setLooping(true);
        }
    }

    public void ComenzarJuego(View view)
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

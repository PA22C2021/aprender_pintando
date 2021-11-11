package com.example.aprender_pintando;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.aprender_pintando.Configuracion.Configuracion;
import com.example.aprender_pintando.Configuracion.ConfiguracionCtrl;
import com.example.aprender_pintando.Helper.AdminSQLiteOpenHelper;

public class MainActivity extends BaseActivity  {

    ConfiguracionCtrl cfgCtrl;
    ImageButton btn_play, btn_grilla, btn_config;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn_play = (ImageButton) findViewById(R.id.btn_play);
        btn_grilla = (ImageButton) findViewById(R.id.btn_grid);
        btn_config = (ImageButton) findViewById(R.id.btn_settings);
        AdminSQLiteOpenHelper db = new AdminSQLiteOpenHelper(this, "aprender_pintando", null , 1);
        Log.d("db ------ " , db.toString());

        cfgCtrl = new ConfiguracionCtrl(this);
        Configuracion cfg = cfgCtrl.getConfiguracion();

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
                    sonidos[i].stop();
            }
            sonidos[rSonido].start();
            sonidos[rSonido].setLooping(true);
        }
    }

    private void iniciarSonidoConfig(int sonido){

        Log.d("var-sonido ------------------------------------------->"  , String.valueOf(sonido));
        Log.d("var-sonido ------------------------------------------->"  , String.valueOf(sonidos));
        if(!sonidos[sonido].isPlaying()){
            for (int i = 0; i< 4; i++) {
                if(sonidos[i].isPlaying())
                    sonidos[i].stop();
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

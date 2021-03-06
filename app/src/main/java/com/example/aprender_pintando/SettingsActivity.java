package com.example.aprender_pintando;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.aprender_pintando.Domain.Configuracion;
import com.example.aprender_pintando.Controller.ConfiguracionCtrl;
import com.example.aprender_pintando.Helper.ColorHelper;

public class SettingsActivity extends BaseActivity  {

    ConfiguracionCtrl cfgCtl;
    ImageView screen;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cfgCtl  = new ConfiguracionCtrl(this);
        int color = getCurrentColorOfDB();
        screen = (ImageView) findViewById(R.id.template_screen);
        screen.setBackgroundColor(color);
    }

    private int getCurrentColorOfDB() {
        Configuracion cfg = cfgCtl.getConfiguracion();
        return Color.parseColor(cfg.getColorConfig());
    }

    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_settings;
    }

    public void setearSonido(View view){

        cargarSonidos();
        int sonido = Integer.parseInt(view.getTag().toString());

        if(rSonido != sonido){
            sonidos[rSonido].pause();
            sonidos[sonido].start();
            rSonido = sonido;
            ConfiguracionCtrl cfg  = new ConfiguracionCtrl(this);
            cfg.actualizarSonidoConfiguracion(rSonido);
        }
    }

    public void setearFondoPantalla(View view){
        int color = Integer.parseInt(view.getTag().toString());
        switch (color){
            case 1:
                screen.setBackgroundColor(Color.parseColor(getString(R.string.screen01)));
                color = R.string.screen01;
                break;
            case 2:
                screen.setBackgroundColor(Color.parseColor(getString(R.string.screen02)));
                color = R.string.screen02;
                break;
            case 3:
                screen.setBackgroundColor(Color.parseColor(getString(R.string.screen03)));
                color = R.string.screen03;
                break;
            case 4:
                screen.setBackgroundColor(Color.parseColor(getString(R.string.screen04)));
                color = R.string.screen04;
                break;
            case 5:
                screen.setBackgroundColor(Color.parseColor(getString(R.string.screen05)));
                color = R.string.screen05;
                break;
            case 6:
                screen.setBackgroundColor(Color.parseColor(getString(R.string.screen06)));
                color = R.string.screen06;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + color);
        }
        ColorHelper.guardarColor(color, view);
    }
}
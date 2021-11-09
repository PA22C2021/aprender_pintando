package com.example.aprender_pintando;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.aprender_pintando.Configuracion.ConfiguracionCtrl;

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
            ConfiguracionCtrl cfg  = new ConfiguracionCtrl(this);
            cfg.actualizarSonidoConfiguracion(rSonido);
        }
    }

    public void setearFondoPantalla(View view){
        int color = Integer.parseInt(view.getTag().toString());
        ConfiguracionCtrl cfg  = new ConfiguracionCtrl(this);
        switch (color){
            case 1:
<<<<<<< HEAD
                // screen.setBackgroundColor(R.string.screen01);
                screen.setBackgroundColor(Color.parseColor("#F9E79F"));
                cfg.actualizarColorConfiguracion("#F9E79F");
                break;
            case 2:
                 // screen.setBackgroundColor(R.string.screen02);
                screen.setBackgroundColor(Color.parseColor("#A3E4D7"));
                cfg.actualizarColorConfiguracion("#A3E4D7");
                break;
            case 3:
                //screen.setBackgroundColor(R.string.screen03);
                screen.setBackgroundColor(Color.parseColor("#C4DE95"));
                cfg.actualizarColorConfiguracion("#C4DE95");
                break;
            case 4:
                //screen.setBackgroundColor(R.string.screen04);
                screen.setBackgroundColor(Color.parseColor("#A9CCE3"));
                cfg.actualizarColorConfiguracion("#A9CCE3");
                break;
            case 5:
                //screen.setBackgroundColor(R.string.screen05);
                screen.setBackgroundColor(Color.parseColor("#FADBD8"));
                cfg.actualizarColorConfiguracion("#FADBD8");
                break;
            case 6:
                //screen.setBackgroundColor(R.string.screen06);
                screen.setBackgroundColor(Color.parseColor("#D2B4DE"));
                cfg.actualizarColorConfiguracion("#D2B4DE");

=======
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
>>>>>>> 0caae03ade8ff48d054528f306818bb68c5601d3

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + color);
        }
    }
}
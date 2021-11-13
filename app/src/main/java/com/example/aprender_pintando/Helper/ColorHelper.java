package com.example.aprender_pintando.Helper;

import android.graphics.Color;
import android.view.View;

import com.example.aprender_pintando.Controller.ConfiguracionCtrl;
import com.example.aprender_pintando.Domain.Configuracion;
import com.example.aprender_pintando.R;

public abstract class ColorHelper {

    public static int getColor(View view){
        ConfiguracionCtrl cfgCtl = new ConfiguracionCtrl(view.getContext());
        Configuracion cfg = cfgCtl.getConfiguracion();
        int ret;

        if(cfg.getColorConfig() != null){
            ret = Color.parseColor(cfg.getColorConfig());
        }else{
            int rNumber = (int) Math.floor(Math.random()*(1-6+1)+6); // Valor entre M y N, ambos incluidos.
            int aux;

            //TO DO: ALMACENAR EL COLOR DE LA DB
            switch (rNumber){
                case 1:
                    aux =  R.string.screen01;
                    break;
                case 2:
                    aux =  R.string.screen02;
                    break;
                case 3:
                    aux =  R.string.screen03;
                    break;
                case 4:
                    aux =  R.string.screen04;
                    break;
                case 5:
                    aux =  R.string.screen05;
                    break;
                case 6:
                    aux =  R.string.screen06;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + rNumber);
            }
            guardarColor(aux, view);
            ret = aux;
        }
        return ret;
    }

    public static void guardarColor(int color, View view){
        ConfiguracionCtrl cfgCtl = new ConfiguracionCtrl(view.getContext());
        cfgCtl.actualizarColorConfiguracion(view.getContext().getString(color));
    }
}

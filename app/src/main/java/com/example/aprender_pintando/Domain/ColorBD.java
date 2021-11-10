package com.example.aprender_pintando.Domain;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.view.View;

import com.example.aprender_pintando.Configuracion.Configuracion;
import com.example.aprender_pintando.Configuracion.ConfiguracionDAO;
import com.example.aprender_pintando.Helper.AdminSQLiteOpenHelper;
import com.example.aprender_pintando.R;

public abstract class ColorBD {

    public static int getColor(View view){
        ConfiguracionDAO cfgDAO = new ConfiguracionDAO();
        cfgDAO.setContext(view.getContext());
        Configuracion cfg = cfgDAO.getConfiguracion();
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
        ConfiguracionDAO cfgDAO = new ConfiguracionDAO();
        cfgDAO.setContext(view.getContext());
        cfgDAO.actualizarColorConfiguracion(view.getContext().getString(color));
    }
}

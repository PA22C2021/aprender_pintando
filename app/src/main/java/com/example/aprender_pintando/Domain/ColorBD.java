package com.example.aprender_pintando.Domain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.aprender_pintando.Helper.AdminSQLiteOpenHelper;
import com.example.aprender_pintando.R;

public abstract class ColorBD {

    public static int getColorJuego(Context context){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "settings", null, 1);
        SQLiteDatabase _dbContext = admin.getReadableDatabase();

        StringBuilder query = new StringBuilder();
        query.append("select * from configuraciones");

        Cursor fila = _dbContext.rawQuery(query.toString(), null);

        int ret;

        if(fila.moveToFirst()){
            //TO DO: TOMAR EL COLOR DE LA DB
            ret = R.string.screen04;
        }else{
            ret = R.string.screen01;
            //throw new IllegalStateException("Unexpected value");
        }

        _dbContext.close();
        return ret;
    }

    public static int getColor(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(view.getContext(), "settings", null, 1);
        SQLiteDatabase _dbContext = admin.getReadableDatabase();

        StringBuilder query = new StringBuilder();
        query.append("select * from configuraciones");

        Cursor fila = _dbContext.rawQuery(query.toString(), null);

        int ret;

        if(fila.moveToFirst()){
            //TO DO: TOMAR EL COLOR DE LA DB
            ret = R.string.screen04;
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

        _dbContext.close();
        return ret;
    }

    private static void guardarColor(int color, View view){
        ContentValues val = new ContentValues();
        val.put("Color", color);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(view.getContext(), "settings", null, 1);
        admin.getWritableDatabase().insert("configuraciones", null, val);
        admin.close();
    }
}

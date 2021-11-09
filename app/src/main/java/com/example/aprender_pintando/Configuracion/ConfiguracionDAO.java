package com.example.aprender_pintando.Configuracion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aprender_pintando.Helper.AdminSQLiteOpenHelper;
import com.example.aprender_pintando.Letra.Letra;

public class ConfiguracionDAO {

    private Context _context;

    public void setContext(Context value){
        this._context = value;
    }

    public boolean actualizarConfiguracion(Configuracion config){

        boolean isOk = false;
        // preguntar a los chicos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, "aprender_pintando", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues configValores = new ContentValues();

        if(config.getSonido() >= 0 && config.getSonido() < 4) {
            configValores.put("sonido", config.getSonido());
        }

        if(!config.getColorConfig().isEmpty()) {
            configValores.put("color", config.getColorConfig());
        }

        int cant = db.update("configuraciones", configValores, null, null);
        if(cant == 1) {
            isOk = true;
        }

        return isOk;

    }

    public boolean actualizarColorConfiguracion(String color){

        boolean isOk = false;
        // preguntar a los chicos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, "aprender_pintando", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues configValores = new ContentValues();

        if(!color.isEmpty()) {
            configValores.put("color", color);
        }

        int cant = db.update("configuraciones", configValores, "1=1", null);
        if(cant == 1) {
            isOk = true;
        }

        return isOk;

    }


    public boolean actualizarSonidoConfiguracion(int sonido){

        boolean isOk = false;
        // preguntar a los chicos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, "aprender_pintando", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues configValores = new ContentValues();

        if(sonido >= 0  && sonido <= 3) {
            configValores.put("sonido", sonido);
        }

        int cant = db.update("configuraciones", configValores, "1=1", null);
        if(cant == 1) {
            isOk = true;
        }

        return isOk;

    }

    public boolean actualizarPartidaIniciadaConfiguracion(boolean partidaIniciada){

        boolean isOk = false;
        // preguntar a los chicos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, "aprender_pintando", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues configValores = new ContentValues();

        configValores.put("partidaIniciada", partidaIniciada);

        int cant = db.update("configuraciones", configValores, "1=1", null);
        if(cant == 1) {
            isOk = true;
        }

        return isOk;

    }

    public Configuracion getConfiguracion(){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, "aprender_pintando", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String query = "SELECT * FROM configuraciones WHERE id = 1";
        Cursor fila = db.rawQuery(query, null);

        int sonido = Integer.parseInt(fila.getString(1));
        String color = fila.getString(2);
        boolean partidaIniciada = fila.getString(3) == "1" ? true : false;

        Configuracion cfg = new Configuracion(sonido,color,partidaIniciada );

        return cfg;

    }



}

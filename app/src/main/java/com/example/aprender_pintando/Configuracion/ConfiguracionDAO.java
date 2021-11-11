package com.example.aprender_pintando.Configuracion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aprender_pintando.Helper.AdminSQLiteOpenHelper;
import com.example.aprender_pintando.Letra.Letra;

public class ConfiguracionDAO {

    private Context _context;
    private static final String dbName = "aprender_pintando";
    private static final int version = 1;

    public ConfiguracionDAO(Context _context) {
        this._context = _context;
    }

    public ConfiguracionDAO() {
    }

    public boolean actualizarConfiguracion(Configuracion config){

        boolean isOk = false;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, dbName, null, version);
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
        db.close();
        return isOk;

    }

    public boolean actualizarColorConfiguracion(String color){

        boolean isOk = false;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, dbName, null, version);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues configValores = new ContentValues();

        if(!color.isEmpty()) {
            configValores.put("color", color);
        }

        int cant = db.update("configuraciones", configValores, null, null);
        if(cant == 1) {
            isOk = true;
        }
        db.close();
        return isOk;

    }


    public boolean actualizarSonidoConfiguracion(int sonido){

        boolean isOk = false;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, dbName, null, version);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues configValores = new ContentValues();

        if(sonido >= 0  && sonido <= 3) {
            configValores.put("sonido", sonido);
        }

        int cant = db.update("configuraciones", configValores, null, null);
        if(cant == 1) {
            isOk = true;
        }
        db.close();
        return isOk;

    }

    public boolean actualizarPartidaIniciadaConfiguracion(boolean partidaIniciada){

        boolean isOk = false;
        // preguntar a los chicos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, "aprender_pintando", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues configValores = new ContentValues();

        configValores.put("partidaIniciada", partidaIniciada);

        int cant = db.update("configuraciones", configValores, null, null);
        if(cant == 1) {
            isOk = true;
        }

        db.close();
        return isOk;
    }

    public Configuracion getConfiguracion(){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, "aprender_pintando", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        String query = "SELECT * FROM configuraciones WHERE id = 1";
        Cursor fila = db.rawQuery(query, null);

        try{
            fila.moveToFirst();
            int sonido = Integer.parseInt(fila.getString(1));
            String color = fila.getString(2);
            boolean partidaIniciada = fila.getString(3) == "1" ? true : false;
            Configuracion cfg = new Configuracion(sonido,color,partidaIniciada );
            fila.close();
            db.close();
            return cfg;
        }
        catch (Exception e){
            throw e;
        }
    }



}

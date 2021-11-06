package com.example.aprender_pintando.Configuracion;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.aprender_pintando.Helper.AdminSQLiteOpenHelper;

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
        configValores.put("sonido", config.getSonido());
        configValores.put("color", config.getColorConfig());
        configValores.put("partidaIniciada", config.getPartidaIniciada());

        int cant = db.update("configuracion", configValores, null, null);
        if(cant == 1) {
            isOk = true;
        }

        return isOk;

    }


}

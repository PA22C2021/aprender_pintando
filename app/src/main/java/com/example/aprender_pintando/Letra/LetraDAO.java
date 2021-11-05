package com.example.aprender_pintando.Letra;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aprender_pintando.Helper.AdminSQLiteOpenHelper;

public class LetraDAO {

    public static int MAX_NRO_LETRA = 27;

    public boolean actualizarLetra( String letra, boolean isVisualized,boolean isCompleted){

        boolean isOk = false;
        // preguntar a los chicos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(null, null, null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues letraValores = new ContentValues();
        letraValores.put("letra", letra);
        letraValores.put("isVisualized", isVisualized);
        letraValores.put("isCompleted", isCompleted);

        int cant = db.update("letras", letraValores, "letra="+letra, null);
        if(cant == 1) {
            isOk = true;
        }

        return isOk;

    }

    public String getSiguienteLetra (int nroLetra){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(null, null, null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        int nroSiguienteLetra = nroLetra + 1;
        String query = "SELECT letra FROM letras WHERE nroLetra = " + nroSiguienteLetra;
        Cursor fila = db.rawQuery(query, null);
        String siguienteLetra = fila.getString(0);

        return siguienteLetra;
    }

}
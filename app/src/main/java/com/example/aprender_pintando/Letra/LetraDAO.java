package com.example.aprender_pintando.Letra;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aprender_pintando.Helper.AdminSQLiteOpenHelper;

public class LetraDAO {

    public static int MAX_NRO_LETRA = 27;
    private Context _context;

    public void setContext(Context value){
        this._context = value;
    }

    public boolean actualizarLetra( Letra l){

        boolean isOk = false;
        // preguntar a los chicos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this._context, "aprender_pintando", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues letraValores = new ContentValues();
        // letraValores.put("letra", l.getLetra());
        letraValores.put("isVisualized", l.isVisualized());
        letraValores.put("isCompleted", l.isCompleted());

        int cant = db.update("letras", letraValores, "letra="+l.getLetra(), null);
        if(cant == 1) {
            isOk = true;
        }

        return isOk;

    }

    public Letra getSiguienteLetra (int nroLetra){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this._context, "aprender_pintando", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        int nroSiguienteLetra = nroLetra + 1;
        String query = "SELECT letra FROM letras WHERE nroLetra = " + nroSiguienteLetra;
        Cursor fila = db.rawQuery(query, null);
        String letra = fila.getString(0);
        boolean isVisualized = fila.getString(1) == "false" ? false : true ;
        boolean isCompleted = fila.getString(2) == "false" ? false : true;
        int _nroLetra = Integer.parseInt(fila.getString(3));

        Letra l = new Letra(letra,isVisualized,isCompleted,_nroLetra);


        return l;
    }

}
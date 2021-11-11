package com.example.aprender_pintando.Letra;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aprender_pintando.Helper.AdminSQLiteOpenHelper;

import java.util.ArrayList;

public class LetraDAO {

    public static int MAX_NRO_LETRA = 27;
    private Context _context;

    public void setContext(Context value){
        this._context = value;
    }

    public boolean actualizarLetra( Letra l){

        boolean isOk = false;
        // preguntar a los chicos
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, "aprender_pintando", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues letraValores = new ContentValues();

        letraValores.put("isVisualized", l.isVisualized());
        letraValores.put("isCompleted", l.isCompleted());

        int cant = db.update("letras", letraValores, "letra="+l.getLetra(), null);
        if(cant == 1) {
            isOk = true;
        }

        db.close();
        return isOk;

    }

    public Letra getSiguienteLetra (int nroLetra){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, "aprender_pintando", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        int nroSiguienteLetra = nroLetra + 1;
        Cursor fila = db.rawQuery("SELECT * FROM letras WHERE nroLetra = " + nroSiguienteLetra, null);
        fila.moveToFirst();

        String letra = fila.getString(0);
        boolean isVisualized = fila.getInt(1) == 0 ? false : true;
        boolean isCompleted = fila.getInt(2) == 0 ? false : true;
        int _nroLetra = fila.getInt(3);

        fila.close();
        db.close();
        return new Letra(letra,isVisualized,isCompleted,_nroLetra);
    }

    public ArrayList<Letra> getTodasLasLetras (){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, "aprender_pintando", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();
        Cursor fila = db.rawQuery("SELECT * FROM letras", null);
        ArrayList<Letra> listado = new ArrayList<Letra>();
        while (fila.moveToNext()) {

            String letra = fila.getString(0);
            boolean isVisualized = fila.getInt(1) == 0 ? false : true;
            boolean isCompleted = fila.getInt(2) == 0 ? false : true;
            int _nroLetra = fila.getInt(3);

            listado.add(new Letra(letra,isVisualized,isCompleted,_nroLetra));
        }
        fila.close();
        db.close();
        return listado;
    }

}
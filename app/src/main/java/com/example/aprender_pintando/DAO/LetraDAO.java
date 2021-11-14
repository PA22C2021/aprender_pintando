package com.example.aprender_pintando.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aprender_pintando.Helper.AdminSQLiteOpenHelper;
import com.example.aprender_pintando.Domain.Letra;

import java.util.ArrayList;

public class LetraDAO extends BaseDAO {



    public LetraDAO(Context _context) {
        super(_context);
    }

    public boolean actualizarLetra( Letra l){

        boolean isOk = false;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, dbName, null, version);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues letraValores = new ContentValues();

        letraValores.put("isVisualized", l.isVisualized());
        letraValores.put("isCompleted", l.isCompleted());

        int cant = db.update("letras", letraValores, "letra = ?", new String[]{l.getLetra()});

        if(cant == 1) {
            isOk = true;
        }

        db.close();
        return isOk;

    }

    public void limpiarLetras(){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, dbName, null, version);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues letraValores = new ContentValues();

        letraValores.put("isVisualized", false);
        letraValores.put("isCompleted", false);

        int cant = db.update("letras", letraValores, "1=1", null);
    }

    public Letra getSiguienteLetra (int nroLetra){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, dbName, null, version);
        SQLiteDatabase db = admin.getReadableDatabase();

        Cursor fila = db.rawQuery("SELECT * FROM letras WHERE nroLetra > " + nroLetra + " AND isCompleted = 0 LIMIT 1"  , null);
        Letra letra = null;
        while (fila.moveToNext()) {
            String string = fila.getString(0);
            boolean isVisualized = fila.getInt(1) == 0 ? false : true;
            boolean isCompleted = fila.getInt(2) == 0 ? false : true;
            int _nroLetra = fila.getInt(3);
            letra = new Letra(string,isVisualized,isCompleted,_nroLetra);
        }


        fila.close();
        db.close();
        return letra;
    }

    public ArrayList<Letra> getTodasLasLetras (){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, dbName, null, version);
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
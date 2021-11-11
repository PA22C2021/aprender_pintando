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
    private static final String dbName = "aprender_pintando";
    private static final int version = 1;

    public LetraDAO() {
    }

    public LetraDAO(Context _context) {
        this._context = _context;
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

        int cant = db.update("letras", letraValores, null, null);
    }

    public Letra getSiguienteLetra (int nroLetra){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(_context, dbName, null, version);
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
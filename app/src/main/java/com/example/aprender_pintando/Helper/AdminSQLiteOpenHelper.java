package com.example.aprender_pintando.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCreateConfiguraciones = "CREATE TABLE configuraciones (_ID integer PRIMARY KEY AUTOINCREMENT, Sonido text, Color text, PartidaIniciada text)";
        String queryCreateLetras = " CREATE TABLE letras (letra varchar(1) PRIMARY KEY, isVisualized Boolean, isCompleted Boolean, integer nroLetra)";
        String queryInsertLetras = " INSERT INTO letras (letra, isVisualized, isCompleted)\n" +
                                    "VALUES\n" +
                                    "('A' , false, false),\n" +
                                    "('B' , false, false),\n" +
                                    "('C' , false, false),\n" +
                                    "('D' , false, false),\n" +
                                    "('E' , false, false),\n" +
                                    "('F' , false, false),\n" +
                                    "('G' , false, false),\n" +
                                    "('H' , false, false),\n" +
                                    "('I' , false, false),\n" +
                                    "('J' , false, false),\n" +
                                    "('K' , false, false),\n" +
                                    "('L' , false, false),\n" +
                                    "('M' , false, false),\n" +
                                    "('N' , false, false),\n" +
                                    "('Ñ' , false, false),\n" +
                                    "('O' , false, false),\n" +
                                    "('P' , false, false),\n" +
                                    "('Q' , false, false),\n" +
                                    "('R' , false, false),\n" +
                                    "('S' , false, false),\n" +
                                    "('T' , false, false),\n" +
                                    "('U' , false, false),\n" +
                                    "('V' , false, false),\n" +
                                    "('W' , false, false),\n" +
                                    "('X' , false, false),\n" +
                                    "('Y' , false, false),\n" +
                                    "('Z' , false, false),";
        String queryInsertConfig = " INSERT INTO configuracion (sonido, color, partidaIniciada) VALUES ('sonido1.mp3', '#ccc', false)";
        String query = queryCreateConfiguraciones + queryCreateLetras /*+ queryInsertLetras + queryInsertConfig*/;
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void abrir(){
        this.getWritableDatabase();
    }


    public void cerrar(){
        this.close();
    }


}

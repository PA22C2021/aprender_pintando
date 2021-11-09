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
        String queryCreateConfiguraciones = "CREATE TABLE configuraciones (id integer PRIMARY KEY AUTOINCREMENT, sonido int, color text, partidaIniciada bit)";
        String queryCreateLetras = " CREATE TABLE letras (letra varchar(1) PRIMARY KEY, isVisualized bit, isCompleted bit, nroLetra integer)";
        String queryInsertLetras = " INSERT INTO letras (letra, isVisualized, isCompleted, nroLetra) " +
                                    "VALUES " +
                                    "('A' , 0, 0, 1)," +
                                    "('B' , 0, 0, 2)," +
                                    "('C' , 0, 0, 3)," +
                                    "('D' , 0, 0, 4)," +
                                    "('E' , 0, 0, 5)," +
                                    "('F' , 0, 0, 6)," +
                                    "('G' , 0, 0, 7)," +
                                    "('H' , 0, 0, 8)," +
                                    "('I' , 0, 0, 9)," +
                                    "('J' , 0, 0, 10)," +
                                    "('K' , 0, 0, 11)," +
                                    "('L' , 0, 0, 12)," +
                                    "('M' , 0, 0, 13)," +
                                    "('N' , 0, 0, 14)," +
                                    "('Ñ' , 0, 0, 15)," +
                                    "('O' , 0, 0, 16)," +
                                    "('P' , 0, 0, 17)," +
                                    "('Q' , 0, 0, 18)," +
                                    "('R' , 0, 0, 19)," +
                                    "('S' , 0, 0, 20)," +
                                    "('T' , 0, 0, 21)," +
                                    "('U' , 0, 0, 22)," +
                                    "('V' , 0, 0, 23)," +
                                    "('W' , 0, 0, 24)," +
                                    "('X' , 0, 0, 25)," +
                                    "('Y' , 0, 0, 26)," +
                                    "('Z' , 0, 0, 27)";
        String queryInsertConfig = " INSERT INTO configuraciones (sonido, color, partidaIniciada) VALUES (-1, \"#F9E79F\", 0)";
        sqLiteDatabase.execSQL(queryCreateConfiguraciones);
        sqLiteDatabase.execSQL(queryInsertConfig);
        sqLiteDatabase.execSQL(queryCreateLetras);
        sqLiteDatabase.execSQL(queryInsertLetras);

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

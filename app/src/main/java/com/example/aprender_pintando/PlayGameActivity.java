package com.example.aprender_pintando;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.aprender_pintando.Confirmation.VolverMenuDialog;
import com.example.aprender_pintando.Domain.AdminSQLiteOpenHelper;

public class PlayGameActivity extends BaseActivity {
    ConstraintLayout view;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ConstraintLayout view = findViewById(R.id.play_game);
        view.setBackgroundColor(getColor());
    }

    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_play_game;
    }
    public void RegresarMenu(View view)
    {
        VolverMenuDialog.GetAlertDialog(view, this).show();
    }

    private int getColor(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "settings", null, 1);
        SQLiteDatabase _dbContext = admin.getReadableDatabase();

        StringBuilder query = new StringBuilder();
        query.append("select * from configuraciones");

        Cursor fila = _dbContext.rawQuery(query.toString(), null);

        int ret;

        if(fila.moveToFirst()){
            //TO DO: TOMAR EL COLOR DE LA DB
            ret = R.string.screen04;
        }else{
            int rNumber = (int) Math.floor(Math.random()*(1-6+1)+6); // Valor entre M y N, ambos incluidos.
            int aux;

            //TO DO: ALMACENAR EL COLOR DE LA DB
            switch (rNumber){
                case 1:
                    aux =  R.string.screen01;
                    break;
                case 2:
                    aux =  R.string.screen02;
                    break;
                case 3:
                    aux =  R.string.screen03;
                    break;
                case 4:
                    aux =  R.string.screen04;
                    break;
                case 5:
                    aux =  R.string.screen05;
                    break;
                case 6:
                    aux =  R.string.screen06;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + rNumber);
            }
            guardarColor(aux);
            ret = aux;
        }

        _dbContext.close();
        return ret;
    }

    private void guardarColor(int color){
        ContentValues val = new ContentValues();
        val.put("Color", color);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "settings", null, 1);
        admin.getWritableDatabase().insert("configuraciones", null, val);
        admin.close();
    }
}
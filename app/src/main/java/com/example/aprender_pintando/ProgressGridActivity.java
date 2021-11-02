package com.example.aprender_pintando;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.GridView;

import com.example.aprender_pintando.Adapter.LetraAdapter;
import com.example.aprender_pintando.Domain.Letra;

import java.util.ArrayList;

public class ProgressGridActivity extends BaseActivity  {
    GridView gridView;

    int imgArray[] = {R.drawable.letra_a};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LetraAdapter adapter = new LetraAdapter(this, listar());

        gridView = (GridView) findViewById(R.id.grilla_progreso);
        gridView.setAdapter(adapter);
    }
    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_progress_grid;
    }

    private ArrayList<Letra> listar(){
        String[] meses = getResources().getStringArray(R.array.letras);
        TypedArray imagenes = getResources().obtainTypedArray(R.array.imagenesLetras);

        ArrayList<Letra> lista = new ArrayList<>();

        for (int i=0;i<meses.length; i++){
            lista.add(new Letra(imagenes.getResourceId(i,0)));
        }
        return lista;
    }
}
package com.example.aprender_pintando;

import android.os.Bundle;
import android.widget.GridView;

import com.example.aprender_pintando.Adapter.LetraAdapter;
import com.example.aprender_pintando.Domain.Letra;
import com.example.aprender_pintando.Controller.LetraCtrl;

import java.util.ArrayList;

public class ProgressGridActivity extends BaseActivity  {
    LetraCtrl lCtrl;
    GridView gridView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lCtrl = new LetraCtrl(this);
        LetraAdapter adapter = new LetraAdapter(this, listar());
        gridView = (GridView) findViewById(R.id.grilla_progreso);
        gridView.setAdapter(adapter);
    }
    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_progress_grid;
    }

    private ArrayList<Letra> listar(){
        return lCtrl.getTodasLasLetras();
    }
}
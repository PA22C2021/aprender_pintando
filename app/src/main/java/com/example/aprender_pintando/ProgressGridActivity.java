package com.example.aprender_pintando;

import android.os.Bundle;
import android.widget.GridView;

public class ProgressGridActivity extends BaseActivity  {
    GridView gridView;

    int imgArray[] = {R.drawable.letra_a};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gridView = findViewById(R.id.grilla_progreso);
    }
    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_progress_grid;
    }
}
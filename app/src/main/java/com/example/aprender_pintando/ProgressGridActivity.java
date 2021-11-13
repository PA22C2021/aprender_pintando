package com.example.aprender_pintando;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.aprender_pintando.Adapter.LetraAdapter;
import com.example.aprender_pintando.Domain.Letra;
import com.example.aprender_pintando.Controller.LetraCtrl;

import java.util.ArrayList;

public class ProgressGridActivity extends BaseActivity  {

    ConstraintLayout view;
    LetraCtrl lCtrl;
    GridView gridView;
    ImageView juegoCompletado;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = (ConstraintLayout) findViewById(R.id.grid_screen);
        lCtrl = new LetraCtrl(this);
        LetraAdapter adapter = new LetraAdapter(this, listar());
        gridView = (GridView) findViewById(R.id.grilla_progreso);
        gridView.setAdapter(adapter);


        if(lCtrl.getLetraPendiente() == null){
            createImage();
            view.addView(juegoCompletado);
            animateImage();
        }

    }
    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_progress_grid;
    }

    private ArrayList<Letra> listar(){
        return lCtrl.getTodasLasLetras();
    }

    private void createImage(){
        juegoCompletado = new ImageView(this);
        juegoCompletado.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Drawable drawable = getResources().getDrawable( R.drawable.juego_completado );
        juegoCompletado.setBackground(drawable);
        int widthImage = 600;
        juegoCompletado.setLayoutParams(new ConstraintLayout.LayoutParams(widthImage,800));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int posX = width / 2 - widthImage / 2;
        juegoCompletado.setX(posX);
        juegoCompletado.setY(300);
    }

    private void animateImage(){

        int time = 800;
        int rotationgrade = 25;
        juegoCompletado.animate().rotation(rotationgrade).setDuration(time);
        juegoCompletado.animate().rotation(0).setDuration(time);
        juegoCompletado.animate().rotation(rotationgrade * -1).setDuration(time);

        juegoCompletado.animate().rotation(rotationgrade).setDuration(time);
        juegoCompletado.animate().rotation(0).setDuration(time);
        juegoCompletado.animate().rotation(rotationgrade * -1).setDuration(time);

        juegoCompletado.animate().rotation(rotationgrade).setDuration(time);
        juegoCompletado.animate().rotation(0).setDuration(time);
        juegoCompletado.animate().rotation(rotationgrade * -1).setDuration(time);

        juegoCompletado.animate().rotation(0).setDuration(time);

        //juegoCompletado.setVisibility(View.INVISIBLE);
    }
}
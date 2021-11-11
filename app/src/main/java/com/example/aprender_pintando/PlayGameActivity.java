package com.example.aprender_pintando;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.aprender_pintando.Configuracion.ConfiguracionDAO;
import com.example.aprender_pintando.Confirmation.VolverMenuDialog;
import com.example.aprender_pintando.Domain.ColorBD;

public class PlayGameActivity extends BaseActivity {
    ConstraintLayout view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConstraintLayout view = findViewById(R.id.play_game);
        view.setBackgroundColor(ColorBD.getColor(view));

        /*ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.letra_completada);
        imageView.setX(0);
        imageView.setY(0);
        view.addView(imageView);*/
    }

    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_play_game;
    }
}
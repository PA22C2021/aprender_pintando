package com.example.aprender_pintando;

import android.os.Bundle;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.aprender_pintando.Confirmation.VolverMenuDialog;

public class PlayGameActivity extends BaseActivity {
    ConstraintLayout view;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ConstraintLayout view = findViewById(R.id.play_game);
        view.setBackgroundColor(R.string.screen01);
    }

    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_play_game;
    }
    public void RegresarMenu(View view)
    {
        VolverMenuDialog.GetAlertDialog(view, this).show();
    }
}
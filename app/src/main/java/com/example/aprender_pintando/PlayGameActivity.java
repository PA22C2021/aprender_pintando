package com.example.aprender_pintando;

import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.aprender_pintando.Helper.ColorHelper;

public class PlayGameActivity extends BaseActivity {
    ConstraintLayout view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConstraintLayout view = findViewById(R.id.play_game);
        view.setBackgroundColor(ColorHelper.getColor(view));
    }

    @Override
    protected int getLayoutResourceId(){
        return R.layout.activity_play_game;
    }
}
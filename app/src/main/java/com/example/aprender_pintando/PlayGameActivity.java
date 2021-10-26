package com.example.aprender_pintando;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.aprender_pintando.Confirmation.ReiniciarLetraDialog;
import com.example.aprender_pintando.Confirmation.VolverMenuDialog;

public class PlayGameActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // Set the color
        getWindow().getDecorView().setBackgroundColor(R.string.screen01);
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
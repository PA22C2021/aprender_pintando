package com.example.aprender_pintando;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aprender_pintando.Confirmation.VolverMenuDialog;

import java.util.Observable;

public abstract class BaseActivity extends AppCompatActivity {

    static MediaPlayer sonidos[] = new MediaPlayer[4];
    static int rSonido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(getLayoutResourceId());
    }
    protected abstract int getLayoutResourceId();

    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
    }

    public void RegresarMenu(View view)
    {
        VolverMenuDialog.GetAlertDialog(view, this).show();
    }
}

package com.example.aprender_pintando;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aprender_pintando.Helper.DialogHelper;

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
        DialogHelper.VolverMenuDialog(view, this).show();
    }

    protected void cargarSonidos(){
        if(sonidos[0] == null)
            sonidos[0] = MediaPlayer.create(this, R.raw.sound01);
        if(sonidos[1] == null)
            sonidos[1] = MediaPlayer.create(this, R.raw.sound02);
        if(sonidos[2] == null)
            sonidos[2] = MediaPlayer.create(this, R.raw.sound03);
        if(sonidos[3] == null)
            sonidos[3] = MediaPlayer.create(this, R.raw.sound04);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}

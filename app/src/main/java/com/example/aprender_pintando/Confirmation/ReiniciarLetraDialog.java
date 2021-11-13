package com.example.aprender_pintando.Confirmation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ProgressBar;

import com.example.aprender_pintando.Domain.Coordenada;
import com.example.aprender_pintando.Domain.Draw;
import com.example.aprender_pintando.Domain.Letra;
import com.example.aprender_pintando.Helper.CoordenadaValidatorHelper;

public abstract class ReiniciarLetraDialog {

    public static AlertDialog GetAlertDialog(View view, Draw draw, ProgressBar progressBar)
    {
        AlertDialog dialogo = new AlertDialog
                .Builder(view.getContext())
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        progressBar.setProgress(0);
                        draw.getCoordValidator().setCantCoordenadasValidas(0);
                        draw.ClearDraw();

                        for (Coordenada c: draw.getCoordValidator().getListaDeCoordenadas()){
                            c.setCompleted(false);
                        }
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setTitle("Reiniciar")
                .setMessage("¿Reiniciar la letra?")
                .create();

        return dialogo;
    }
}
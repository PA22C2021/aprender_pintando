package com.example.aprender_pintando.Confirmation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

import com.example.aprender_pintando.Domain.Draw;

public abstract class ReiniciarLetraDialog {

    public static AlertDialog GetAlertDialog(View view, Draw draw)
    {
        AlertDialog dialogo = new AlertDialog
                .Builder(view.getContext())
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        draw.ClearDraw();
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
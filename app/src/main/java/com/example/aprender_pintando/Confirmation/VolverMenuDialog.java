package com.example.aprender_pintando.Confirmation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

import com.example.aprender_pintando.Domain.Draw;
import com.example.aprender_pintando.PlayGameActivity;

public class VolverMenuDialog
{
    public static AlertDialog GetAlertDialog(View view, PlayGameActivity playGameActivity)
    {
        AlertDialog dialogo = new AlertDialog
                .Builder(view.getContext())
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        playGameActivity.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setTitle("Reiniciar")
                .setMessage("¿Volver al menú?")
                .create();

        return dialogo;
    }
}

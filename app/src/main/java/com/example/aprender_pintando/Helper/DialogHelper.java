package com.example.aprender_pintando.Helper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aprender_pintando.Domain.Coordenada;
import com.example.aprender_pintando.Domain.Draw;
import com.example.aprender_pintando.MainActivity;

public abstract class DialogHelper {
    public static AlertDialog VolverMenuDialog(View view, AppCompatActivity activity)
    {
        AlertDialog.Builder builder = new AlertDialog
                .Builder(view.getContext());
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finish();
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                activity.startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setTitle("ATENCION");
        builder.setMessage("¿Volver al menú?");
        AlertDialog dialogo = builder
                .create();

        return dialogo;
    }
    public static AlertDialog ReiniciarLetraDialog(View view, Draw draw, ProgressBar progressBar)
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
                .setTitle("REINICIAR")
                .setMessage("¿Reiniciar letra?")
                .create();

        return dialogo;
    }

    public static AlertDialog ConfirmSiguienteLetra(View view)
    {
        AlertDialog.Builder builder = new AlertDialog
                .Builder(view.getContext());
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setTitle("LETRA INCOMPLETA");
        builder.setMessage("¿Continuar?");
        AlertDialog dialogo = builder
                .create();

        return dialogo;
    }
}

package com.example.aprender_pintando.Confirmation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aprender_pintando.Domain.Draw;
import com.example.aprender_pintando.MainActivity;
import com.example.aprender_pintando.PlayGameActivity;

public class VolverMenuDialog
{
    public static AlertDialog GetAlertDialog(View view, AppCompatActivity activity)
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
}

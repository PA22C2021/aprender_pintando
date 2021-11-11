package com.example.aprender_pintando;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.aprender_pintando.Confirmation.ReiniciarLetraDialog;
import com.example.aprender_pintando.Domain.ColorBD;
import com.example.aprender_pintando.Domain.Draw;
import com.example.aprender_pintando.Domain.MotorJuego;
import com.example.aprender_pintando.Letra.Letra;

public class DrawFragment extends Fragment {

    TextView tvLetraActual;
    Draw draw;
    ProgressBar progressBar;
    ImageView imageLetra;
    ImageButton btnReiniciar, btnTerminar;
    MotorJuego motorJuego;

    public DrawFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_draw, container, false);

        motorJuego = new MotorJuego();

        draw = new Draw(view.getContext());
        draw.setBackgroundColor(ColorBD.getColor(view));

        tvLetraActual = (TextView) getActivity().findViewById(R.id.lblLetra);
        btnReiniciar = (ImageButton) getActivity().findViewById(R.id.btnReiniciar);
        imageLetra = (ImageView) getActivity().findViewById(R.id.imageLetra);
        btnTerminar = (ImageButton) getActivity().findViewById(R.id.btnTerminar);
        progressBar = (ProgressBar) getActivity().findViewById(R.id.progresoJuego);

        btnReiniciar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ReiniciarLetraButtonOnClick(view);
            }
        });

        btnTerminar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TerminarButtonOnClick(view);
            }
        });

        return draw;
    }

    public void TerminarButtonOnClick(View view)
    {
        draw.ClearDraw();
        Letra letra = motorJuego.LetraSiguiente();

        if (letra != null)
        {
            imageLetra.setImageResource(letra.getUrlImagen());
            tvLetraActual.setText(letra.toString());
        }
        else
        {
            Intent intent = new Intent(view.getContext(), ProgressGridActivity.class);
            startActivity(intent);
        }
    }

    public void ReiniciarLetraButtonOnClick(View view)
    {
        if (!draw.isClean())
        {
            ReiniciarLetraDialog.GetAlertDialog(view, draw).show();
        }
    }
}
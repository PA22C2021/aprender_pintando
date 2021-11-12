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
import com.example.aprender_pintando.Domain.Coordenada;
import com.example.aprender_pintando.Helper.CoordenadaValidatorHelper;
import com.example.aprender_pintando.Domain.ColorBD;
import com.example.aprender_pintando.Domain.Draw;
import com.example.aprender_pintando.Domain.MotorJuego;
import com.example.aprender_pintando.Domain.Letra;
import com.example.aprender_pintando.Controller.LetraCtrl;

public class DrawFragment extends Fragment {

    TextView tvLetraActual;
    Draw draw;
    ProgressBar progressBar;
    ImageView imageLetra;
    ImageButton btnReiniciar, btnTerminar;
    MotorJuego motorJuego;
    Letra letra = new Letra();
    LetraCtrl lCtrl;

    public DrawFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_draw, container, false);
        draw = new Draw(view.getContext());
        draw.setBackgroundColor(ColorBD.getColor(view));

        tvLetraActual = (TextView) getActivity().findViewById(R.id.lblLetra);
        btnReiniciar = (ImageButton) getActivity().findViewById(R.id.btnReiniciar);
        imageLetra = (ImageView) getActivity().findViewById(R.id.imageLetra);
        btnTerminar = (ImageButton) getActivity().findViewById(R.id.btnTerminar);
        progressBar = (ProgressBar) getActivity().findViewById(R.id.progresoJuego);

        lCtrl = new LetraCtrl(getContext());
        motorJuego = new MotorJuego(view.getContext());

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

        this.letra.setVisualized(true);
        this.lCtrl.actualizarLetra(this.letra);

        CoordenadaValidatorHelper cvAUX = draw.getCoordValidator();
        cvAUX.setListaDeCoordenadas(this.letra.getCoordenadas());
        draw.setCoordValidator(cvAUX);



        progressBar.setMax(this.letra.getCoordenadas().size());
        return draw;
    }



    public void TerminarButtonOnClick(View view)
    {
        draw.ClearDraw();
        progressBar.setProgress(this.letra.getCoordenadas().size()/2);
        letra = motorJuego.LetraSiguiente();

        if (letra != null)
        {
            imageLetra.setImageResource(letra.getUrlImagen());
            tvLetraActual.setText(letra.toString());
            motorJuego.setLetra(letra);
            this.letra.setVisualized(true);
            this.lCtrl.actualizarLetra(this.letra);
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
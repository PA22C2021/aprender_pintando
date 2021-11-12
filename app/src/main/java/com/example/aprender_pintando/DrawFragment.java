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

    Draw draw;
    TextView tvLetraActual;
    ProgressBar progressBar;
    ImageView imageLetra, letraCompletada;
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
        letraCompletada = (ImageView) getActivity().findViewById(R.id.letra_completada);
        btnTerminar = (ImageButton) getActivity().findViewById(R.id.btnTerminar);
        progressBar = (ProgressBar) getActivity().findViewById(R.id.progresoJuego);

        lCtrl = new LetraCtrl(getContext());
        motorJuego = new MotorJuego(getContext());

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
        draw.setMotorJuego(motorJuego);
        draw.setlCtrl(lCtrl);
        draw.setLetra(letra);
        draw.setProgressBar(progressBar);
        draw.setLetraCompletada(letraCompletada);
        draw.setBtnTerminar(btnTerminar);
        draw.setBtnReiniciar(btnReiniciar);


        progressBar.setMax(this.letra.getCoordenadas().size());


        return draw;
    }

    public void TerminarButtonOnClick(View view)
    {
        draw.ClearDraw();
        letra = motorJuego.LetraSiguiente();

        if (letra != null)
        {
            imageLetra.setImageResource(letra.getUrlImagen());
            tvLetraActual.setText(letra.toString());
            motorJuego.setLetra(letra);

            CoordenadaValidatorHelper cvAUX = draw.getCoordValidator();
            cvAUX.setListaDeCoordenadas(this.letra.getCoordenadas());
            draw.setCoordValidator(cvAUX);

            draw.getCoordValidator().setCantCoordenadasValidas(0);
            progressBar.setProgress(0);
            progressBar.setMax(letra.getCoordenadas().size());
            this.letra.setVisualized(true);
            this.lCtrl.actualizarLetra(this.letra);
            draw.ClearDraw();
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
            progressBar.setProgress(0);
            CoordenadaValidatorHelper cvAUX = draw.getCoordValidator();
            cvAUX.setListaDeCoordenadas(this.letra.getCoordenadas());
            draw.setCoordValidator(cvAUX);

            ReiniciarLetraDialog.GetAlertDialog(view, draw).show();
        }
    }
}
package com.example.aprender_pintando;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.aprender_pintando.Configuracion.ConfiguracionCtrl;
import com.example.aprender_pintando.Confirmation.ReiniciarLetraDialog;
import com.example.aprender_pintando.Coordenadas.CoordenadasLetra;
import com.example.aprender_pintando.Coordenadas.CoordenadasValidator;
import com.example.aprender_pintando.Coordenadas.LetraA;
import com.example.aprender_pintando.Domain.ColorBD;
import com.example.aprender_pintando.Domain.Draw;
import com.example.aprender_pintando.Domain.MotorJuego;
import com.example.aprender_pintando.Letra.Letra;
import com.example.aprender_pintando.Letra.LetraCtrl;

import java.util.Observable;
import java.util.Observer;

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

        draw.setCoordLetra(this.getCoordenadasLetra());

        CoordenadasValidator cvAUX = draw.getCoordValidator();
        cvAUX.setListaDeCoordenadas(this.getCoordenadasLetra().getCoordenadas());
        draw.setCoordValidator(cvAUX);



        progressBar.setMax(this.getCoordenadasLetra().getCoordenadas().size());
        return draw;
    }



    public void TerminarButtonOnClick(View view)
    {
        draw.ClearDraw();
        progressBar.setProgress(this.getCoordenadasLetra().getCoordenadas().size()/2);
        letra = motorJuego.LetraSiguiente();

        if (letra != null)
        {

            imageLetra.setImageResource(letra.getUrlImagen());
            tvLetraActual.setText(letra.toString());
            motorJuego.setLetra(letra);
        }
        else
        {
            Intent intent = new Intent(view.getContext(), ProgressGridActivity.class);
            startActivity(intent);
        }

        this.letra.setVisualized(true);
        this.lCtrl.actualizarLetra(this.letra);
    }

    public void ReiniciarLetraButtonOnClick(View view)
    {
        if (!draw.isClean())
        {
            ReiniciarLetraDialog.GetAlertDialog(view, draw).show();
        }
    }


    public CoordenadasLetra getCoordenadasLetra(){

        String letra = this.letra.getLetra();
        CoordenadasLetra x = new CoordenadasLetra();
        switch (letra)
        {
            case "A":
                x = new LetraA();
                break;
            /*case "B":
                url = R.drawable.letra_b;
                break;
            case "C":
                url = R.drawable.letra_c;
                break;
            case "D":
                url = R.drawable.letra_d;
                break;
            case "E":
                url = R.drawable.letra_e;
                break;
            case "F":
                url = R.drawable.letra_f;
                break;
            case "G":
                url = R.drawable.letra_g;
                break;
            case "H":
                url = R.drawable.letra_h;
                break;
            case "I":
                url = R.drawable.letra_i;
                break;
            case "J":
                url = R.drawable.letra_j;
                break;
            case "K":
                url = R.drawable.letra_k;
                break;
            case "L":
                url = R.drawable.letra_l;
                break;
            case "M":
                url = R.drawable.letra_m;
                break;
            case "N":
                url = R.drawable.letra_n;
                break;
            case "Ñ":
                url = R.drawable.letra_n2;
                break;
            case "O":
                url = R.drawable.letra_o;
                break;
            case "P":
                url = R.drawable.letra_p;
                break;
            case "Q":
                url = R.drawable.letra_q;
                break;
            case "R":
                url = R.drawable.letra_r;
                break;
            case "S":
                url = R.drawable.letra_s;
                break;
            case "T":
                url = R.drawable.letra_t;
                break;
            case "U":
                url = R.drawable.letra_u;
                break;
            case "V":
                url = R.drawable.letra_v;
                break;
            case "W":
                url = R.drawable.letra_w;
                break;
            case "X":
                url = R.drawable.letra_x;
                break;
            case "Y":
                url = R.drawable.letra_y;
                break;
            case "Z":
                url = R.drawable.letra_z;
                break;*/
        }
        return x;
    }

}
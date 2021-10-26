package com.example.aprender_pintando;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.aprender_pintando.Confirmation.ReiniciarLetraDialog;
import com.example.aprender_pintando.Domain.Draw;

public class DrawFragment extends Fragment {

    Draw draw;
    ImageButton btnReiniciar, btnTerminar;

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

        draw = new Draw(view.getContext());

        btnReiniciar = (ImageButton) getActivity().findViewById(R.id.btnReiniciar);
        btnTerminar = (ImageButton) getActivity().findViewById(R.id.btnTerminar);

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
        Toast.makeText(view.getContext(), "Juego finalizado", Toast.LENGTH_LONG).show();
    }

    public void ReiniciarLetraButtonOnClick(View view)
    {
        if (!draw.isClean())
        {
            ReiniciarLetraDialog.GetAlertDialog(view, draw).show();
        }
    }
}
package com.example.aprender_pintando;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


import com.example.aprender_pintando.Confirmation.ReiniciarLetraDialog;
import com.example.aprender_pintando.Domain.Draw;

public class DrawFragment extends Fragment {

    Draw draw;
    ImageButton btnReiniciar;

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
        draw.setBackgroundColor(R.string.screen01);

        btnReiniciar = (ImageButton) getActivity().findViewById(R.id.btnReiniciar);
        btnReiniciar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (!draw.isClean())
                {
                    ReiniciarLetraDialog.GetAlertDialog(view, draw).show();
                }
            }
        });

        return draw;
    }
}
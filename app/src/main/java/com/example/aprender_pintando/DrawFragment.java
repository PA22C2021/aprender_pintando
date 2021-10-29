package com.example.aprender_pintando;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;


import com.example.aprender_pintando.Confirmation.ReiniciarLetraDialog;
import com.example.aprender_pintando.Domain.AdminSQLiteOpenHelper;
import com.example.aprender_pintando.Domain.Draw;

public class DrawFragment extends Fragment {

    Draw draw;
    ImageButton btnReiniciar, btnTerminar, btnRojo, btnVerde, btnAzul;
    SeekBar seekBar;

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
        draw.setBackgroundColor(getColor(getContext()));

        btnReiniciar = (ImageButton) getActivity().findViewById(R.id.btnReiniciar);
        btnTerminar = (ImageButton) getActivity().findViewById(R.id.btnTerminar);
        btnRojo = (ImageButton) getActivity().findViewById(R.id.btnRojo);
        btnVerde = (ImageButton) getActivity().findViewById(R.id.btnVerde);
        btnAzul = (ImageButton) getActivity().findViewById(R.id.btnAzul);
        seekBar = (SeekBar) getActivity().findViewById(R.id.barTrazo);


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

        btnRojo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                draw.SetColor(Color.RED);
            }
        });

        btnVerde.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                draw.SetColor(Color.GREEN);
            }
        });

        btnAzul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                draw.SetColor(Color.BLUE);
            }
        });

        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);

        return draw;
    }

    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb
            draw.SetStroke(progress + 15);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };

    private int getColor(Context context){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "settings", null, 1);
        SQLiteDatabase _dbContext = admin.getReadableDatabase();

        StringBuilder query = new StringBuilder();
        query.append("select * from configuraciones");

        Cursor fila = _dbContext.rawQuery(query.toString(), null);

        int ret;

        if(fila.moveToFirst()){
            //TO DO: TOMAR EL COLOR DE LA DB
            ret = R.string.screen04;
        }else{
            ret = R.string.screen01;
            //throw new IllegalStateException("Unexpected value");
        }

        _dbContext.close();
        return ret;
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
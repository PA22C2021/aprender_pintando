package com.example.aprender_pintando.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.aprender_pintando.Domain.Letra;
import com.example.aprender_pintando.R;

import java.util.ArrayList;

public class LetraAdapter extends BaseAdapter {
    private ArrayList<Letra> elementos;
    private Context context;

    public LetraAdapter(Context context, ArrayList<Letra> elementos) {
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Letra getItem(int position) {
        return elementos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view = convertView;
        if (convertView == null){
            view = inflater.inflate(R.layout.grid_template,null);
        }

        ImageView imagen = (ImageView) view.findViewById(R.id.imagen);
        imagen.setImageResource(getItem(position).getUrl());
        return view;
    }
}

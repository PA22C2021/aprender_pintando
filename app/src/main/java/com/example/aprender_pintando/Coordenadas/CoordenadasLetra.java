package com.example.aprender_pintando.Coordenadas;

import android.util.Log;

// import com.example.aprender_pintando.Domain.Cordenada;

import java.util.ArrayList;

public class CoordenadasLetra {
    private int x;
    private int y;
    private boolean completed;
    private ArrayList<CoordenadasLetra> coordenadas;

    public CoordenadasLetra() {
    }


    /*public CoordenadasLetra(int x, int y, boolean completed, ArrayList<CoordenadasLetra> coordenadas) {
        this.x = x;
        this.y = y;
        this.completed = completed;
        this.coordenadas = coordenadas;
    }*/

    public CoordenadasLetra(int x, int y, boolean completed) {
        this.x = x;
        this.y = y;
        this.completed = completed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ArrayList<CoordenadasLetra> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<CoordenadasLetra> coordenadas) {
        this.coordenadas = coordenadas;
    }
}

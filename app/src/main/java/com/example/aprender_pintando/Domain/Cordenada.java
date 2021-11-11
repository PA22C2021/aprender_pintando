package com.example.aprender_pintando.Domain;

import android.util.Log;

import java.util.ArrayList;

public class Cordenada {
    private int x;
    private int y;
    private boolean completed;

    public Cordenada(int x, int y, boolean completed) {
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

    public static ArrayList<Cordenada> getAllPixelesReferencias(){

        ArrayList<Cordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Cordenada(715, 579, false));
        Cordenadas.add(new Cordenada(608, 722, false));
        Cordenadas.add(new Cordenada(589, 907, false));
        Cordenadas.add(new Cordenada(555, 1093, false));
        Cordenadas.add(new Cordenada(526, 1281, false));
        Cordenadas.add(new Cordenada(711, 1119, false));
        Cordenadas.add(new Cordenada(864, 1122, false));
        Cordenadas.add(new Cordenada(840, 950, false));
        Cordenadas.add(new Cordenada(797, 765, false));
        Cordenadas.add(new Cordenada(870, 1305, false));
        Log.d("Size  ----> " , Cordenadas.size() +  "");

        return Cordenadas;
    }


}

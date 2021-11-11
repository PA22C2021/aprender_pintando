package com.example.aprender_pintando.Letra;

import android.util.Log;

// import com.example.aprender_pintando.Domain.Cordenada;
import com.example.aprender_pintando.Helper.LetrasHelper;

import java.util.ArrayList;

public class Letra extends LetraDAO {

    private String letra = "A";
    private boolean isVisualized = false;
    private boolean isCompleted = false;
    private int nroLetra = 1;

    public Letra(String letra, boolean isVisualized, boolean isCompleted, int nroLetra) {
        this.letra = letra;
        this.isVisualized = isVisualized;
        this.isCompleted = isCompleted;
        this.nroLetra = nroLetra;
    }

    public Letra() {
    }

    /*public static ArrayList<Cordenada> getAllPixelesReferencias(){

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

        return Cordenadas;
    }*/

    public int getUrlImagen(){
        return LetrasHelper.UrlLetra(this.letra);
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public boolean isVisualized() {
        return isVisualized;
    }

    public void setVisualized(boolean visualized) {
        isVisualized = visualized;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getNroLetra() {
        return nroLetra;
    }

    public void setNroLetra(int nroLetra) {
        this.nroLetra = nroLetra;
    }

    @Override
    public String toString() {
        return "Letra: " + this.letra;
    }
}

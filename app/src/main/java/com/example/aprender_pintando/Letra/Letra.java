package com.example.aprender_pintando.Letra;

import com.example.aprender_pintando.Helper.LetrasHelper;

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

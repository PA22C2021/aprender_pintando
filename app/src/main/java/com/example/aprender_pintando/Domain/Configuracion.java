package com.example.aprender_pintando.Domain;

public class Configuracion {

    private int sonido;
    private String color;
    private boolean partidaIniciada;

    public Configuracion() {
    }

    public Configuracion(int sonido , String color, boolean partidaIniciada) {
        this.sonido = sonido;
        this.color = color;
        this.partidaIniciada = partidaIniciada;
    }

    public int getSonido() {
        return sonido;
    }

    public void setSonido(int sonido) {
        this.sonido = sonido;
    }

    public String getColorConfig() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getPartidaIniciada() {
        return partidaIniciada;
    }

    public void setPartidaIniciada(boolean partidaIniciada) {
        this.partidaIniciada = partidaIniciada;
    }


}

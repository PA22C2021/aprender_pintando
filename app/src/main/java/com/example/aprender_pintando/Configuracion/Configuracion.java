package com.example.aprender_pintando.Configuracion;

public class Configuracion extends ConfiguracionDAO {

    private String sonido;
    private String color;
    private boolean partidaIniciada;

    public Configuracion(String sonido, String color, boolean partidaIniciada) {
        this.sonido = sonido;
        this.color = color;
        this.partidaIniciada = partidaIniciada;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
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

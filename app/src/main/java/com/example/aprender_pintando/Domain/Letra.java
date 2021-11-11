package com.example.aprender_pintando.Domain;

import com.example.aprender_pintando.Enum.LetraEnum;
import com.example.aprender_pintando.Helper.LetrasHelper;

public class Letra {

    private int UrlImagen;
    private boolean Completa = false;
    private boolean Visualizada = false;
    private LetraEnum Letra;
    private int NroLetra;

    public Letra(LetraEnum letra)
    {
        this.Letra = letra;
        UrlImagen = LetrasHelper.UrlLetra(letra);
    }

    public int getUrl()
    {
        return UrlImagen;
    }


    public void setLetra(LetraEnum letra)
    {
        this.Letra = letra;
    }

    public LetraEnum getLetra()
    {
        return this.Letra;
    }

    public void setVisualizada(boolean visualizada)
    {
        this.Visualizada = visualizada;
    }

    public boolean getVisualizada()
    {
        return this.Visualizada;
    }

    public void setCompletada(boolean completa)
    {
        this.Completa = completa;
    }

    public boolean getCompletada()
    {
        return this.Completa;
    }

    public void setNroLetra(int nroLetra)
    {
        this.NroLetra = nroLetra;
    }

    public int getNroLetra()
    {
        return this.NroLetra;
    }

    @Override
    public String toString() {
        return "Letra: " + Letra.toString();
    }

    public void setUrlImage(int resourceId) {
        this.UrlImagen = resourceId;
    }
}

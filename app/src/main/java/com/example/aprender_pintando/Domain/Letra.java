package com.example.aprender_pintando.Domain;

import com.example.aprender_pintando.Enum.LetraEnum;
import com.example.aprender_pintando.Helper.LetrasHelper;

public class Letra {

    private int UrlImagen;
    private boolean Completa = false;
    private LetraEnum Letra = LetraEnum.A;

    public Letra()
    {
        UrlImagen = LetrasHelper.UrlLetra(Letra);
    }

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

    @Override
    public String toString() {
        return "Letra: " + Letra.toString();
    }
}

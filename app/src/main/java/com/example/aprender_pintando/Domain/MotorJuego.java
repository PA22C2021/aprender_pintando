package com.example.aprender_pintando.Domain;
import android.content.Context;

import com.example.aprender_pintando.Controller.LetraCtrl;

public class MotorJuego {

    private LetraCtrl lCtrl;
    private Letra Letra;

    // Si estamos comenzando el juego llamando a este constructor alcanza, inicia en la letra A.
    public MotorJuego(Context context)
    {
        this.lCtrl = new LetraCtrl(context);

    }

    // Si estamos leyendo de la base hay que enviar la letra por parametro.
    public MotorJuego(Context context, Letra letra)
    {
        this.lCtrl = new LetraCtrl(context);
        this.Letra = letra;
    }



    public Letra getLetra() { return this.Letra; }

    public void setLetra(Letra letra){
        this.Letra = letra;
    }

    public Letra LetraSiguiente()
    {
        return lCtrl.getSiguienteLetra(Letra.getNroLetra());
    }
}

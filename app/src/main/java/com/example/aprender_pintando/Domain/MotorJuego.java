package com.example.aprender_pintando.Domain;
import com.example.aprender_pintando.Letra.Letra;

import java.util.Arrays;

public class MotorJuego {

    private Letra Letra;

    // Si estamos comenzando el juego llamando a este constructor alcanza, inicia en la letra A.
    public MotorJuego()
    {
        //TODO: ver como traer de la db y limpiar campos
        this.Letra = new Letra();
    }

    // Si estamos leyendo de la base hay que enviar la letra por parametro.
    public MotorJuego(Letra letra)
    {
         this.Letra = letra;
    }

    public Letra LetraSiguiente()
    {
        return null;
    }
}

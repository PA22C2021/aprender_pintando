package com.example.aprender_pintando.Domain;

import com.example.aprender_pintando.Enum.LetraEnum;

import java.util.Arrays;

public class MotorJuego {

    private Letra Letra;

    // Si estamos comenzando el juego llamando a este constructor alcanza, inicia en la letra A.
    public MotorJuego()
    {
        this.Letra = new Letra();
    }

    // Si estamos leyendo de la base hay que enviar la letra por parametro.
    public MotorJuego(LetraEnum letraEnum)
    {
         this.Letra = new Letra(letraEnum);
    }

    public Letra LetraSiguiente()
    {
        LetraEnum letra = Letra.getLetra();
        int index = Arrays.asList(LetraEnum.values()).indexOf(letra);

        if (index < (LetraEnum.values().length - 1))
        {
            letra = LetraEnum.values()[index+1];

            Letra = new Letra(letra);
            return Letra;
        }

        return null;
    }
}

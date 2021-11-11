package com.example.aprender_pintando.Coordenadas;

import android.util.Log;

// import com.example.aprender_pintando.Domain.Cordenada;

import java.util.ArrayList;
import java.util.Observable;

public class CoordenadasValidator {

    private int cantCoordenadasValidas;
    private ArrayList<CoordenadasLetra> listaDeCoordenadas;
    private boolean letraCompleta;


    public int getCantCoordenadasValidas() {
        return cantCoordenadasValidas;
    }

    public void setCantCoordenadasValidas(int cantCoordenadasValidas) {
        this.cantCoordenadasValidas = cantCoordenadasValidas;
    }

    public ArrayList<CoordenadasLetra> getListaDeCoordenadas() {
        return listaDeCoordenadas;
    }

    public void setListaDeCoordenadas(ArrayList<CoordenadasLetra> listaDeCoordenadas) {
        this.listaDeCoordenadas = listaDeCoordenadas;
    }

    public boolean isLetraCompleta() {
        return letraCompleta;
    }

    public void setLetraCompleta(boolean letraCompleta) {

        this.letraCompleta = letraCompleta;
        if(letraCompleta){

        }
    }


    public boolean validarCoordenadas (float touchX, float touchY){


        for(CoordenadasLetra c : this.listaDeCoordenadas){
            float pixelWithMarginErrorXPlus = c.getX() + 90;
            float pixelWithMarginErrorXMinus = c.getX() - 90;
            float pixelWithMarginErrorYPlus = c.getY() + 90;
            float pixelWithMarginErrorYMinus = c.getY() - 90;
            if(touchX <= pixelWithMarginErrorXPlus && touchX >= pixelWithMarginErrorXMinus &&
                    touchY <= pixelWithMarginErrorYPlus && touchY >= pixelWithMarginErrorYMinus
            ){
                if (!c.getCompleted()) {
                    c.setCompleted(true);
                    this.setCantCoordenadasValidas(this.getCantCoordenadasValidas() + 1);
                    // Log.d("Tildo  un pixel", this.getCantCoordenadasValidas() + "");
                    // Log.d("Size", this.listaDeCoordenadas.size() + "");
                }
            }
        }

        boolean estaCompleta =  false;

        if(this.getCantCoordenadasValidas() == this.listaDeCoordenadas.size() ){
            // TODO: mostrar imagen
            //  System.out.println("Termino!!!: ");
            estaCompleta = true;
            setLetraCompleta(true);
        }

        return estaCompleta;

    }


}

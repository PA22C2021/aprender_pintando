package com.example.aprender_pintando.Helper;

// import com.example.aprender_pintando.Domain.Cordenada;

import com.example.aprender_pintando.Domain.Coordenada;

import java.util.ArrayList;

public class CoordenadaValidatorHelper {

    private int cantCoordenadasValidas;
    private ArrayList<Coordenada> listaDeCoordenadas;
    private boolean letraCompleta;


    public int getCantCoordenadasValidas() {
        return cantCoordenadasValidas;
    }

    public void setCantCoordenadasValidas(int cantCoordenadasValidas) {
        this.cantCoordenadasValidas = cantCoordenadasValidas;
    }

    public ArrayList<Coordenada> getListaDeCoordenadas() {
        return listaDeCoordenadas;
    }

    public void setListaDeCoordenadas(ArrayList<Coordenada> listaDeCoordenadas) {
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
        int errorMargin = 75;
        for(Coordenada c : this.listaDeCoordenadas){
            float pixelWithMarginErrorXPlus = c.getX() + errorMargin;
            float pixelWithMarginErrorXMinus = c.getX() - errorMargin;
            float pixelWithMarginErrorYPlus = c.getY() + errorMargin;
            float pixelWithMarginErrorYMinus = c.getY() - errorMargin;
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

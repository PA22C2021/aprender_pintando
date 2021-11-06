package com.example.aprender_pintando.Letra;

public class LetraResponse {
    private boolean isGameFinished;
    private Letra letra;

    public LetraResponse(boolean isGameFinished, Letra letra) {
        this.letra = letra;
        this.isGameFinished = isGameFinished;
    }

    public LetraResponse() {
    }


    public void setGameFinished(boolean gameFinished) {
        isGameFinished = gameFinished;
    }

    public void setLetra(Letra letra) {
        this.letra = letra;
    }

    public Letra getLetra() {
        return this.letra;
    }

    public boolean getIsGameFinished() {
        return this.isGameFinished;
    }
}

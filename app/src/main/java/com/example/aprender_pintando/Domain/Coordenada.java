package com.example.aprender_pintando.Domain;

import java.util.ArrayList;

public class Coordenada {
    private int x;
    private int y;
    private boolean completed;

    public Coordenada() {
    }

    public Coordenada(int x, int y, boolean completed) {
        this.x = x;
        this.y = y;
        this.completed = completed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

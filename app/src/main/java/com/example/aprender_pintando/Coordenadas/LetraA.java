package com.example.aprender_pintando.Coordenadas;

// import com.example.aprender_pintando.Domain.Cordenada;

import java.util.ArrayList;

public class LetraA extends CoordenadasLetra {

    public LetraA() {
        super();
        ArrayList<CoordenadasLetra> c = this.getAllCoordenadas();
        setCoordenadas(c);
    }


    /*public LetraA(int x, int y, boolean completed) {
        super(x, y, completed);
        ArrayList<CoordenadasLetra> c = this.getAllCoordenadas();
        setCoordenadas(c);
    }*/

    public static ArrayList<CoordenadasLetra> getAllCoordenadas(){
        ArrayList<CoordenadasLetra> Cordenadas = new ArrayList<>();
        Cordenadas.add(new CoordenadasLetra(715, 579, false));
        Cordenadas.add(new CoordenadasLetra(608, 722, false));
        Cordenadas.add(new CoordenadasLetra(589, 907, false));
        Cordenadas.add(new CoordenadasLetra(555, 1093, false));
        Cordenadas.add(new CoordenadasLetra(526, 1281, false));
        Cordenadas.add(new CoordenadasLetra(711, 1119, false));
        Cordenadas.add(new CoordenadasLetra(864, 1122, false));
        Cordenadas.add(new CoordenadasLetra(840, 950, false));
        Cordenadas.add(new CoordenadasLetra(797, 765, false));
        Cordenadas.add(new CoordenadasLetra(870, 1305, false));
        return Cordenadas;
    }
}

package com.example.aprender_pintando.Helper;

import com.example.aprender_pintando.Domain.Coordenada;
import com.example.aprender_pintando.R;

import java.util.ArrayList;

public abstract class LetraHelper
{
    public static int UrlLetra(String letra)
    {
        switch (letra)
        {
            case "A":
                return R.drawable.letra_a;
            case "B":
                return R.drawable.letra_b;
            case "C":
                return R.drawable.letra_c;
            case "D":
                return R.drawable.letra_d;
            case "E":
                return R.drawable.letra_e;
            case "F":
                return R.drawable.letra_f;
            case "G":
                return R.drawable.letra_g;
            case "H":
                return R.drawable.letra_h;
            case "I":
                return R.drawable.letra_i;
            case "J":
                return R.drawable.letra_j;
            case "K":
                return R.drawable.letra_k;
            case "L":
                return R.drawable.letra_l;
            case "M":
                return R.drawable.letra_m;
            case "N":
                return R.drawable.letra_n;
            case "Ñ":
                return R.drawable.letra_n2;
            case "O":
                return R.drawable.letra_o;
            case "P":
                return R.drawable.letra_p;
            case "Q":
                return R.drawable.letra_q;
            case "R":
                return R.drawable.letra_r;
            case "S":
                return R.drawable.letra_s;
            case "T":
                return R.drawable.letra_t;
            case "U":
                return R.drawable.letra_u;
            case "V":
                return R.drawable.letra_v;
            case "W":
                return R.drawable.letra_w;
            case "X":
                return R.drawable.letra_x;
            case "Y":
                return R.drawable.letra_y;
            case "Z":
                return R.drawable.letra_z;
            default:
                return 0;
        }
    }

    public static ArrayList<Coordenada> getAllCoordenadasLetra(String letra)
    {
        switch (letra)
        {
            case "A":
                return coordenadasLetraA();
            case "B":
                return coordenadasLetraB();
            case "C":
                return coordenadasLetraC();
            case "D":
                return coordenadasLetraD();
            case "E":
                return coordenadasLetraE();
            case "F":
                return coordenadasLetraF();
            case "G":
                return coordenadasLetraG();
            case "H":
                return coordenadasLetraH();
            case "I":
                return coordenadasLetraI();
            case "J":
                return coordenadasLetraJ();
            case "K":
                return coordenadasLetraK();
            case "L":
                return coordenadasLetraL();
            case "M":
                return coordenadasLetraM();
            case "N":
                return coordenadasLetraN();
            case "Ñ":
                return coordenadasLetraN2();
            case "O":
                return coordenadasLetraO();
            case "P":
                return coordenadasLetraP();
            case "Q":
                return coordenadasLetraQ();
            case "R":
                return coordenadasLetraR();
            case "S":
                return coordenadasLetraS();
            case "T":
                return coordenadasLetraT();
            case "U":
                return coordenadasLetraU();
            case "V":
                return coordenadasLetraV();
            case "W":
                return coordenadasLetraW();
            case "X":
                return coordenadasLetraX();
            case "Y":
                return coordenadasLetraY();
            case "Z":
                return coordenadasLetraZ();
            default:
                return new ArrayList<>();
        }

    }

    private static ArrayList<Coordenada> coordenadasLetraA(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraB(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraC(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraD(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraE(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraF(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraG(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraH(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraI(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraJ(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraK(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraL(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraM(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraN(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraN2(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraO(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraP(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraQ(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraR(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraS(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraT(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraU(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraV(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraW(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraX(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraY(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
    private static ArrayList<Coordenada> coordenadasLetraZ(){
        ArrayList<Coordenada> Cordenadas = new ArrayList<>();
        Cordenadas.add(new Coordenada(715, 579, false));
        Cordenadas.add(new Coordenada(608, 722, false));
        Cordenadas.add(new Coordenada(589, 907, false));
        Cordenadas.add(new Coordenada(555, 1093, false));
        Cordenadas.add(new Coordenada(526, 1281, false));
        Cordenadas.add(new Coordenada(711, 1119, false));
        Cordenadas.add(new Coordenada(864, 1122, false));
        Cordenadas.add(new Coordenada(840, 950, false));
        Cordenadas.add(new Coordenada(797, 765, false));
        Cordenadas.add(new Coordenada(870, 1305, false));
        return Cordenadas;
    }
}
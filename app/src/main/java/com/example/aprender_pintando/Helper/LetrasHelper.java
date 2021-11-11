package com.example.aprender_pintando.Helper;

import com.example.aprender_pintando.Enum.LetraEnum;
import com.example.aprender_pintando.R;

public abstract class LetrasHelper
{
    public static int UrlLetra(String letra)
    {
        int url = 0;

        switch (letra)
        {
            case "A":
                url = R.drawable.letra_a;
                break;
            case "B":
                url = R.drawable.letra_b;
                break;
            case "C":
                url = R.drawable.letra_c;
                break;
            case "D":
                url = R.drawable.letra_d;
                break;
            case "E":
                url = R.drawable.letra_e;
                break;
            case "F":
                url = R.drawable.letra_f;
                break;
            case "G":
                url = R.drawable.letra_g;
                break;
            case "H":
                url = R.drawable.letra_h;
                break;
            case "I":
                url = R.drawable.letra_i;
                break;
            case "J":
                url = R.drawable.letra_j;
                break;
            case "K":
                url = R.drawable.letra_k;
                break;
            case "L":
                url = R.drawable.letra_l;
                break;
            case "M":
                url = R.drawable.letra_m;
                break;
            case "N":
                url = R.drawable.letra_n;
                break;
            case "Ñ":
                url = R.drawable.letra_n2;
                break;
            case "O":
                url = R.drawable.letra_o;
                break;
            case "P":
                url = R.drawable.letra_p;
                break;
            case "Q":
                url = R.drawable.letra_q;
                break;
            case "R":
                url = R.drawable.letra_r;
                break;
            case "S":
                url = R.drawable.letra_s;
                break;
            case "T":
                url = R.drawable.letra_t;
                break;
            case "U":
                url = R.drawable.letra_u;
                break;
            case "V":
                url = R.drawable.letra_v;
                break;
            case "W":
                url = R.drawable.letra_w;
                break;
            case "X":
                url = R.drawable.letra_x;
                break;
            case "Y":
                url = R.drawable.letra_y;
                break;
            case "Z":
                url = R.drawable.letra_z;
                break;
        }

        return url;
    }
}

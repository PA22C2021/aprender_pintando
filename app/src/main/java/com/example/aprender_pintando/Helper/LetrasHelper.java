package com.example.aprender_pintando.Helper;

import com.example.aprender_pintando.Enum.LetraEnum;
import com.example.aprender_pintando.R;

public abstract class LetrasHelper
{
    public static int UrlLetra(LetraEnum letraEnum)
    {
        int url = 0;

        switch (letraEnum)
        {
            case A:
                url = R.drawable.letra_a;
                break;

            case Z:
                url = R.drawable.prueba;
                break;
        }

        return url;
    }
}

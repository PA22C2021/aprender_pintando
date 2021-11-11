package com.example.aprender_pintando.Letra;

import static com.example.aprender_pintando.Letra.LetraDAO.MAX_NRO_LETRA;

import android.content.Context;
import java.util.ArrayList;

public class LetraCtrl {

    private Context _context;

    public LetraCtrl(Context context) {
        setContext(context);
    }

    public void setContext(Context _context) {
        this._context = _context;
    }

    public LetraResponse updateAndGetSiguienteLetra (String letra, boolean isCompleted, boolean isVisualized, int nroLetra) {
        Letra l = new Letra(letra, isCompleted, isVisualized, nroLetra);
        boolean isOk = l.actualizarLetra(l);
        LetraResponse ret = new LetraResponse();


        if(isOk) {

            if(l.getNroLetra() == MAX_NRO_LETRA){
                // Si es la letra es la numero 27 (Z) entonces el juego finaliza (ver que hacer luego)
                ret.setLetra(l);
                ret.setGameFinished(true);
            } else {
                // Si es cualquier otra, se sigue normalmente
                Letra siguienteLetra = this.getSiguienteLetra(l.getNroLetra());
                ret.setLetra(siguienteLetra);
                ret.setGameFinished(false);
            }

        }
        return ret;
    }

    public Letra getSiguienteLetra (int nroLetra) {
        LetraDAO lDao = new LetraDAO();
        lDao.setContext(this._context);
        Letra letra = lDao.getSiguienteLetra(nroLetra);
        return letra;
    }

    public ArrayList<Letra> getTodasLasLetras () {
        LetraDAO lDao = new LetraDAO();
        lDao.setContext(this._context);
        return lDao.getTodasLasLetras();
    }
}


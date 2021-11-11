package com.example.aprender_pintando.Letra;

import static com.example.aprender_pintando.Letra.LetraDAO.MAX_NRO_LETRA;

import android.content.Context;
import java.util.ArrayList;

public class LetraCtrl {

    private Context _context;
    private LetraDAO lDao;

    public LetraCtrl(Context _context) {
        this._context = _context;
        lDao = new LetraDAO(this._context);
    }

    public boolean actualizarLetra (Letra letra) {
        return lDao.actualizarLetra(letra);
    }

    public void limpiarLetras () {
        lDao.limpiarLetras();
    }

    public Letra getSiguienteLetra (int nroLetra) {
        if(nroLetra == MAX_NRO_LETRA){
            return null;
        }else {
            return lDao.getSiguienteLetra(nroLetra);
        }
    }

    public ArrayList<Letra> getTodasLasLetras () {
        return lDao.getTodasLasLetras();
    }
}


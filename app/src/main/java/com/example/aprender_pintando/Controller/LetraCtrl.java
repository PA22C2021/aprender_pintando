package com.example.aprender_pintando.Controller;

import android.content.Context;
import com.example.aprender_pintando.DAO.LetraDAO;
import com.example.aprender_pintando.Domain.Letra;
import java.util.ArrayList;

public class LetraCtrl extends BaseController {

    private LetraDAO lDao;
    private static final int MAX_NRO_LETRA = 27;

    public LetraCtrl(Context _context) {
        super(_context);
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

    public Letra getLetraPendiente(){
        ArrayList<Letra> lista = lDao.getTodasLasLetras();
        for (Letra l : lista){
            if(!l.isCompleted()){
                return l;
            }
        }

        return null;

    }


}


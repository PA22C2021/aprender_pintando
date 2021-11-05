package com.example.aprender_pintando.Letra;

public class LetraCtrl {

    public void actualizarLetra (String letra, boolean isCompleted, boolean isVisualized) {
        LetraDAO lDao = new LetraDAO();
        boolean isOk = lDao.actualizarLetra(letra, isVisualized, isCompleted);
        if(isOk) {
            // todo next letra
        } else {
            // todo ver que hacer en este caso
        }
    }

    public void getSiguienteLetra (int nroLetra) {
        LetraDAO lDao = new LetraDAO();
        String letra = lDao.getSiguienteLetra(nroLetra);
        if(!letra.isEmpty()) {
            // todo next letra
        } else {
            // todo ver que hacer en este caso
        }
    }


}

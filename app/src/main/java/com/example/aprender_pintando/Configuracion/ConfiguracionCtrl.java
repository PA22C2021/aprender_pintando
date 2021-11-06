package com.example.aprender_pintando.Configuracion;

import android.content.Context;

public class ConfiguracionCtrl {

    private Context _context;

    public void setcontext(Context _context) {
        this._context = _context;
    }

    public boolean actualizarConfiguracion (String sonido, String color, boolean partidaIniciada){
        boolean isOk = false;

        Configuracion cfg = new Configuracion(sonido, color, partidaIniciada) ;
        cfg.setContext(_context);
        isOk = cfg.actualizarConfiguracion(cfg);

        return isOk;
    }

}

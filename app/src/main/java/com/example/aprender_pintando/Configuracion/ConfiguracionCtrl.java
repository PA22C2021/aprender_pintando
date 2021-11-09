package com.example.aprender_pintando.Configuracion;

import android.content.Context;

public class ConfiguracionCtrl {

    private Context _context;

    public ConfiguracionCtrl(Context context) {
        setContext(context);
    }

    public void setContext(Context _context) {
        this._context = _context;
    }

    public boolean actualizarConfiguracion (int sonido, String color, boolean partidaIniciada){
        boolean isOk = false;

        Configuracion cfg = new Configuracion(sonido, color, partidaIniciada) ;
        cfg.setContext(_context);
        isOk = cfg.actualizarConfiguracion(cfg);

        return isOk;
    }

    public boolean actualizarColorConfiguracion (String color){
        boolean isOk = false;

        Configuracion cfg = new Configuracion() ;
        cfg.setContext(_context);
        isOk = cfg.actualizarColorConfiguracion(color);

        return isOk;
    }


    public boolean actualizarSonidoConfiguracion (int sonido){
        boolean isOk = false;

        Configuracion cfg = new Configuracion() ;
        cfg.setContext(_context);
        isOk = cfg.actualizarSonidoConfiguracion(sonido);

        return isOk;
    }


    public boolean actualizarPartidaIniciadaConfiguracion (boolean partidaIniciada){
        boolean isOk = false;

        Configuracion cfg = new Configuracion() ;
        cfg.setContext(_context);
        isOk = cfg.actualizarPartidaIniciadaConfiguracion(partidaIniciada);

        return isOk;
    }

    public Configuracion getConfiguracion  () {
        Configuracion cfg = new Configuracion() ;
        cfg.setContext(_context);
        return cfg.getConfiguracion();
    }



}

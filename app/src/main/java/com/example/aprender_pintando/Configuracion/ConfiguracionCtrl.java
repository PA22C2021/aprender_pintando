package com.example.aprender_pintando.Configuracion;

import android.content.Context;

public class ConfiguracionCtrl {

    private Context _context;
    private ConfiguracionDAO configuracionDAO;

    public ConfiguracionCtrl(Context _context) {
        this._context = _context;
        configuracionDAO = new ConfiguracionDAO(this._context);
    }

    public boolean actualizarConfiguracion (int sonido, String color, boolean partidaIniciada){
        return configuracionDAO.actualizarConfiguracion(new Configuracion(sonido, color, partidaIniciada));
    }

    public boolean actualizarColorConfiguracion (String color){
        return configuracionDAO.actualizarColorConfiguracion(color);
    }


    public boolean actualizarSonidoConfiguracion (int sonido){
        return configuracionDAO.actualizarSonidoConfiguracion(sonido);
    }

    public boolean actualizarPartidaIniciadaConfiguracion (boolean partidaIniciada){
        return  configuracionDAO.actualizarPartidaIniciadaConfiguracion(partidaIniciada);
    }

    public Configuracion getConfiguracion  () {
        return configuracionDAO.getConfiguracion();
    }



}

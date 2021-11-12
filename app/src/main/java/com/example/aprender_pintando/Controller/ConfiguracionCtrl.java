package com.example.aprender_pintando.Controller;

import android.content.Context;

import com.example.aprender_pintando.Domain.Configuracion;
import com.example.aprender_pintando.DAO.ConfiguracionDAO;

public class ConfiguracionCtrl extends BaseController {

    private ConfiguracionDAO configuracionDAO;

    public ConfiguracionCtrl(Context _context) {
        super(_context);
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

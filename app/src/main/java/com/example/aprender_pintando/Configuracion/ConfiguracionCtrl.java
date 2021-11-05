package com.example.aprender_pintando.Configuracion;

public class ConfiguracionCtrl {

    public boolean actualizarConfiguracion (String sonido, String color, boolean partidaIniciada){
        boolean isOk = false;

        Configuracion cfg = new Configuracion(sonido, color, partidaIniciada) ;
        isOk = cfg.actualizarConfiguracion(cfg);

        return isOk;
    }

}

package com.examen.msv4.config;

public class mapper {
    
    private static final String BASE_URL = "/api/v4";

    public static class Seguridad {
        public static final String SEGURIDAD_BASE = BASE_URL + "/seguridad";
        public static final String LOGIN = SEGURIDAD_BASE + "/{nombre}/{clave}";
        public static final String GET_ALL = SEGURIDAD_BASE;
    }

}

package com.examen.msv2.config;

public class mapper {
    
    private static final String BASE_URL = "/api/v2";

    public static class Articulo {
        public static final String ARTICULO_BASE = BASE_URL + "/articulo";
        public static final String CREATE = ARTICULO_BASE;
        public static final String GET_ALL = ARTICULO_BASE;
    }

}

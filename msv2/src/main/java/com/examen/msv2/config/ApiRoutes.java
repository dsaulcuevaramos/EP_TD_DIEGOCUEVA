package com.examen.msv2.config;

public class ApiRoutes {

    public static final String BASE = "/api/v2";

    public static class clienteRoutes {
        public static final String BASE_CLIENTE = BASE + "/cliente";
        public static final String GET_BY_ID = BASE_CLIENTE + "/{id_cliente}";
        public static final String GET_ALL = BASE_CLIENTE;
        public static final String CREATE = BASE_CLIENTE;
        public static final String DELETE = BASE_CLIENTE + "/{id_cliente}";
        public static final String UPDATE = BASE_CLIENTE + "/{id_cliente}";
    }
}

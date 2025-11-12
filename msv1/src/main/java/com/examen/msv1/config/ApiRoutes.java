package com.examen.msv1.config;

public class ApiRoutes {

    public static final String BASE = "/api/v1";

    public static class Movimiento {

        public static final String USUARIO_BASE = BASE + "/movimiento";
        public static final String CREATE = USUARIO_BASE;
        public static final String GET_ALL = USUARIO_BASE;
        public static final String GET_BY_ID = USUARIO_BASE + "/{id}";
        public static final String UPDATE = USUARIO_BASE + "/{id}";
        public static final String DELETE = USUARIO_BASE + "/{id}";
    }

}

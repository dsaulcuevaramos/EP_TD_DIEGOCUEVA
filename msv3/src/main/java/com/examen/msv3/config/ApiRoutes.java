package com.examen.msv3.config;

public class ApiRoutes {

    public static final String BASE_API = "/api/v3";

    public static class Producto {
        public static final String BASE = BASE_API + "/productos";
        public static final String CREATE = BASE;
        public static final String GET_BY_ID = BASE + "/{id_producto}";
        public static final String DELETE = BASE + "/{id_producto}";
        public static final String GET_ALL = BASE;
        public static final String UPDATE = BASE + "/{id_producto}";

    }

}

package com.examen.msv4.config;

public class ApiRoutes {

    private static final String BASE_URL = "/api/v4";

    public static class Sell {
        public static final String SELL_BASE = BASE_URL + "/sells";
        public static final String CREATE = SELL_BASE;
        public static final String GET_BY_ID = SELL_BASE + "/{id_sell}";
        public static final String GET_ALL = SELL_BASE;
        public static final String DELETE = SELL_BASE + "/{id_sell}";
        public static final String UPDATE = SELL_BASE + "/{id_sell}";

    }
}

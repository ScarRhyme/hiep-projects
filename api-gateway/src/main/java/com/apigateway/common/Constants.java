package com.apigateway.common;

public class Constants {

    public static class ZUUL_FILTER_TYPE {

        // Sau khi nhan request den service dich
        public static final String POST = "post";
        // Truoc khi request den service dich
        public static final String PRE = "pre";
    }

    public interface CORS_FILTER {

        public static final String ALLOW_METHODS = "POST, PUT, GET, OPTIONS, DELETE";
        public static final String ALLOW_HEADERS = "Authorization, Content-Type";
    }
}

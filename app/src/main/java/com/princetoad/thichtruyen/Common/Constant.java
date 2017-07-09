package com.princetoad.thichtruyen.Common;

/**
 * Created by PRINCETOAD on 09/07/2017.
 */

public class Constant {
    public static class RETROFIT {
        public static final String BASE_URL = "http://truyenvoz.esy.es";
        public static final int READ_TIME_OUT = 50;
        public static final int CONNECT_TIME_OUT = 50;
    }

    public static class ERROR {
        public static final int NO_ANSWER = 401;
        public static final int CONFLICT = 409;
        public static final int NOT_FOUND = 404;
        public static final int NO_CONTENT = 204;
        public static final String CONNECT_ERROR = "Lỗi kết nối, vui lòng kiểm tra kết nối mạng và thử lại sau";
    }
}

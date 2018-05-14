package com.princetoad.thichtruyen.Common;

/**
 * Created by PRINCETOAD on 09/07/2017.
 */

public class Constant {
    public static final String BOOK = "truyen";
    public static class RETROFIT {
        public static final String BASE_URL = "http://truyenvoz.esy.es";
        public static final int READ_TIME_OUT = 100;
        public static final int CONNECT_TIME_OUT = 100;
    }

    public static class RESULT_REQUEST{
        public static final String OK = "OK";
        public static final String ERROR = "ERROR";
    }

    public static class ERROR {
        public static final int NO_ANSWER = 401;
        public static final int CONFLICT = 409;
        public static final int NOT_FOUND = 404;
        public static final int NO_CONTENT = 204;
        public static final String CONNECT_ERROR = "Lỗi kết nối, vui lòng kiểm tra kết nối mạng và thử lại sau";
    }

    public static class TYPE {
        public static final int NGONTINH = 1;
        public static final int TEEN = 2;
        public static final int XUYENKHONG = 3;
        public static final int DAMMY = 4;
        public static final int VOZ = 5;
        public static final int KIEMHIEP = 6;
        public static final int SACHIEP = 7;
        public static final int NGAN = 8;
        public static final int DOTHI = 9;
        public static final int TRINHTHAM = 10;
        public static final int THAMKIN = 11;
        public static final int KINHDI = 12;
    }

    public static class INFO_BOOK{
        public static final String ID_BOOK = "idBook";
        public static final String ID_CHAP = "idChap";
        public static final String NUMBER_CHAP = "numberChap";
        public static final String CONTENT_CHAP = "contentChap";
        public static final String NAME_CHAP = "nameChap";
    }
}

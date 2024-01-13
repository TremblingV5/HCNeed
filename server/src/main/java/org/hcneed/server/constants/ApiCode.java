package org.hcneed.server.constants;

import java.util.HashMap;
import java.util.Map;

public class ApiCode {
    public static Map<Integer, String> errorMap = new HashMap<Integer, String>();

    public static int SUCCESS = 0;
    public static int INTERNAL_SERVER_ERROR = -1;

    public static String getMessage(int code) {
        return errorMap.get(code);
    }
}

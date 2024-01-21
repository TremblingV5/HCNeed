package org.hcneed.server.constants;

import java.util.HashMap;
import java.util.Map;

public class ApiCode {
    public static Map<Integer, String> errorMap = new HashMap<Integer, String>();

    public static int SUCCESS = 0;
    public static int INTERNAL_SERVER_ERROR = -1;
    public static int PARAMS_NULL = 1001;
    public static int PARAMS_ILLEGAL = 1002;

    public static String getMessage(int code) {
        errorMap.put(SUCCESS, "success");
        errorMap.put(INTERNAL_SERVER_ERROR, "服务器内部错误");

        errorMap.put(PARAMS_NULL, "参数不能为空");
        errorMap.put(PARAMS_ILLEGAL, "参数不合法");

        return errorMap.get(code);
    }
}

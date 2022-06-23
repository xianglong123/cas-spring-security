package com.cas.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2022/6/23 2:37 下午
 * @desc
 */
public class WebUtils {

    public static String renderString(HttpServletResponse response, String json) {
        try {
            response.setContentType("application/json");
            response.setStatus(200);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}

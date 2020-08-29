package com.example.demo.utils;

import com.example.demo.constant.CommonConstant;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {

    public static String getSession(String key) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
             return request.getSession().getAttribute(key).toString();
    }
    public static String getUserId() {
      return  getSession(CommonConstant.USER_ID);
    }
}

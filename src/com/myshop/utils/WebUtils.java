package com.myshop.utils;

import com.myshop.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class WebUtils {
    public static <T> T copyParamToBean(Map value, T Bean){
        try {
            BeanUtils.populate(Bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Bean;
    }
    public static int parseInt(String strInt,int defaultVaule){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultVaule;
    }
}


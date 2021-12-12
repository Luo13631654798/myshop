package com.myshop.test;

import com.myshop.utils.JdbcUtils;
import jdk.jfr.StackTrace;

public class JdbcUtilsTest {
    public void testJdbcUtils(){
        System.out.println(JdbcUtils.getConnection());
    }
}

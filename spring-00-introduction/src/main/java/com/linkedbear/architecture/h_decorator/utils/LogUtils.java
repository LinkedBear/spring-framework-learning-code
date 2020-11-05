package com.linkedbear.architecture.h_decorator.utils;

import java.util.Arrays;

public class LogUtils {
    
    public static void printLog(String className, String methodName, Object... args) {
        System.out.println(className + " " + methodName + " ...");
        System.out.println("参数列表: " + Arrays.toString(args));
    }
}

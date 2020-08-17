package com.linkedbear.spring.bean.b_scope.code;

public class ScopeReviewDemo {
    // 类级别成员
    private static String classVariable = "";
    
    // 对象级别成员
    private String objectVariable = "";
    
    public static void main(String[] args) throws Exception {
        // 方法级别成员
        String methodVariable = "";
        for (int i = 0; i < args.length; i++) {
            // 循环体局部成员
            String partVariable = args[i];
            
            // 此处能访问哪些变量？
            // classVariable、objectVariable、methodVariable、partVariable
        }
        
        // 此处能访问哪些变量？
        // classVariable、objectVariable、methodVariable
    }
    
    public void test() {
        // 此处能访问哪些变量？
        // classVariable、objectVariable
    }
    
    public static void staticTest() {
        // 此处能访问哪些变量？
        // classVariable
    }
    
}

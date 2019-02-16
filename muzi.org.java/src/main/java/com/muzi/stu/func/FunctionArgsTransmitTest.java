package com.muzi.stu.func;
/*
  基本数据类型和及对应的引用类型 都是值传递
 */
public class FunctionArgsTransmitTest {
    public static void function1(Boolean b){
        b = true;
        System.out.println("function in value:" + b);
    }
    public static void function2(boolean b){
        b = true;
        System.out.println("function in value:" + b);
    }

    public static void main(String[] args){
       boolean b = false;
       Boolean b1 = new Boolean(false);
       function1(b);
       System.out.println(b);
       function1(b1);
       System.out.println(b1);
    }
}

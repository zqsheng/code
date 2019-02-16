package com.muzi.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BackTrace {

    public static void main(String[] args) {
        int n = 3;
        int leftnum = n, rightnum = n;//左括号和右括号都各有n个
        ArrayList<String> results = new ArrayList<String>();//用于存放解空间
        parentheses("", results, leftnum, rightnum);
        for (String s : results)
            System.out.println(s);
    }
    public static void parentheses(String sublist, ArrayList<String> results, int left, int right){
        if(left == 0&& right == 0)//结束
            results.add(sublist);
        if(right>left)//选择和条件。对于不同的if顺序，输出的结果顺序是不一样的，但是构成一样的解空间
            parentheses(sublist+")", results, left, right-1);
        if(left>0)
            parentheses(sublist+"(", results, left-1, right);
    }
}

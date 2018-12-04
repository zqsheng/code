package com.muzi.stu.string;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    /**
     *邮件地址的用户名不断加1
     */
    private static String getNextEmail(String email){
        String[] strs = email.split("@");
        String userName = strs[0];
        String reg = "(\\d+)$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(userName);
        if(m.find()){
            String numberStr = m.group();
            int number = Integer.valueOf(numberStr);
            return m.replaceAll(String.valueOf(number + 1)) + "@" + strs[1];
        }
        return strs[0] + "1" + "@"+ strs[1];
    }

    /**
     *多符号分割
     */
    private static List<String> stringSplits(String str){
        String[] strs = str.split(",|\\s+|，|\\.|。");
        for(String s : strs){
            System.out.println(s);;
        }
        return Arrays.asList(strs);
    }
    /**
     *提取中英文括号里的内容
     */
    private static String getBracketInContent(String source){
        String regex =  "[\\(（][^\\(（]+[\\)）]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        String code = null;
        if(matcher.find()){
             code = matcher.group();
            if(code.length() > 2){
                code = code.substring(1,code.length() - 1);
            }else{
                code = null;
            }
        }
        return code;
    }

    /**
     * 提取中文括号外部的内容
     */
    private static String getBracketOutContent(String source){
        String regex =  "\\s*[\\(（][^\\(（]*[\\)）]\\s*";
        String ret = source.replaceAll(regex,"");
        return ret;
    }
    public static void  main(String[] args){
//        String email = "zqsheng2@jiuqi.com.cn";
//        System.out.println(getNextEmail(email));
//        String source = "张三(),历史,王五 周六，s2.cehis。fjdsjf";
//        stringSplits(source);
        String source = "zhansan(003)";
        for(String s : new String[]{"sh(33)","sh（fdskf）","fds（kkk)","fdskf(dsdaas）","fdsdf()"})
//            getBracketInContent(s);
            System.out.println(getBracketOutContent(s));

    }
}

package com.muzi.stu.numerical;

import java.util.ArrayList;
import java.util.List;

public class NumericalUtils {
    public static  void main(String[] args){
        int cycle = 3;
        int dayCount = 10 ;
        int target = 2;
       System.out.println(getRowsByCycle(cycle,target,dayCount));
    }
    private static List<Integer> getRowsByCycle(int cycle,int target,int dayCount){
        List<Integer> indexRows = new ArrayList<Integer>();
        for(int i = 1;i <= dayCount;i++){
            if(cycle == 1){
                indexRows.add(i);
                continue;
            }
            if(i % cycle == target){
                indexRows.add(i);
            }
        }
        return indexRows;
    }
}

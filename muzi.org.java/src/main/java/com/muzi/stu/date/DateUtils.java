package com.muzi.stu.date;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static void main(String[] args){
        System.out.println(new Date(getWeekEndChinese(System.currentTimeMillis())));
    }
    public static long getWeekBegin(long date){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar. DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTimeInMillis();
    }

    /**
     * 7-1
     * @param date
     * @return
     */
    public static long getWeekEndForEnglish(long date){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return cal.getTimeInMillis();
    }

    /**
     *  1-7
     * @param date
     * @return
     */
    public static long getWeekEndChinese(long date){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        if(cal.getTimeInMillis() < getWeekEndForEnglish(date)){
            cal.add(Calendar.WEEK_OF_YEAR,1);
        }
        return cal.getTimeInMillis();
    }
}

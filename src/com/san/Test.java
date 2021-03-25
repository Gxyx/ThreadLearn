package com.san;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/25/9:46
 */
public class Test {

    public static String getDateTime(){
        SimpleDateFormat format ;
        Date date=null;
        Calendar myDate=Calendar.getInstance();
        myDate.setTime(new java.util.Date());
        date=myDate.getTime();

        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strRtn=format.format(date);
        return strRtn;
    }

    public static void main(String[] args) {
        System.out.println(getDateTime());
    }
}

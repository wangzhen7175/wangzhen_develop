package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static Date getDate8(Date date) {

        String dateStr = getDateString8(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
public static String getDateString8(Date date){

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    return sdf.format(date);
}

}

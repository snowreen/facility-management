package com.facility.management.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static java.sql.Date convertToSqlDate(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public static java.util.Date convertToUtilDate(java.sql.Date sDate) {
        java.util.Date uDate = new java.util.Date(sDate.getTime());
        return uDate;
    }

    public static Date getParsedDate(String date) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateformat.parse(date);
        } catch (ParseException e) {
            System.err.println("Date parsed exception !!!");
            e.printStackTrace();
        }
        return null;
    }

    public static String getStringDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.format(date);
        } catch (Exception e) {
            System.err.println("Date format exception !!!");
            e.printStackTrace();
        }
        return null;
    }

    public static String getStringDateTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.format(date);
        } catch (Exception e) {
            System.err.println("Date format exception !!!");
            e.printStackTrace();
        }
        return null;
    }

    public static Date createDateTime(int year, int month, int day, int hour, int minute) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day, hour, minute);
        return cal.getTime();
    }

}

package com.example.myapplication.view.Lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public final static String CALENDAR_HEADER_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String YEAR_FORMAT = "yyyy";
    public final static String MONTH_FORMAT = "MM";
    public final static String DAY_FORMAT = "d";
    public final static String HOUR_FORMAT = "HH";
    public final static String MIN_FORMAT = "mm";
    public final static String SEC_FORMAT = "ss";

    public static String getDate(long date, String pattern) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.ENGLISH);
            Date d = new Date(date);
            return formatter.format(d).toUpperCase();
        } catch (Exception e) {
            return " ";
        }
    }
}

/*
* 호출 시 이런 식으로 사용된다.
// 2019-03-28 23:28:49
DateUtil.getDate(date, DateUtil.CALENDAR_HEADER_FORMAT);
// EX : 2019
DateUtil.getDate(date, DateUtil.YEAR_FORMAT);
// EX : 03
DateUtil.getDate(date, DateUtil.MONTH_FORMAT);
// EX : 28
DateUtil.getDate(date, DateUtil.MONTH_FORMAT);


[출처] 안드로이드 - 커스텀 달력 및 년,일,월 구하기 Calendar Recyclerview|작성자 길상
*/
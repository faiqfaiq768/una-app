package com.faiq.una.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FaiqDateFormat {
    public static Date ddMMyyyyToPostgreSql(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date utilDate = simpleDateFormat.parse(date);
        java.sql.Date mysqlFormatDate = new java.sql.Date(utilDate.getTime());
        return mysqlFormatDate;
    }
    public static String currentYearMonth(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }
}

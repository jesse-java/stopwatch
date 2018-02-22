package com.naldojesse.com.models;

import java.sql.Timestamp;
import java.util.*;
import java.text.SimpleDateFormat;

public class Timer implements java.io.Serializable{
    private Timestamp start;
    private Timestamp stop;

    public Timer() {
        start = new Timestamp(System.currentTimeMillis());
        stop = null;
    }


    //method that converts a long into a formatted date
    public static String convertTime(long timestamp) {
        TimeZone tz = TimeZone.getDefault();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm a");
        formatter.setTimeZone(tz);

        Date date = new Date(timestamp);
        String dateFormatted = formatter.format(date);
        System.out.println(dateFormatted);
        return dateFormatted;
    }


    //converts a timestamp into milliseconds, seconds, and minutes
    public static String convertMS(long milliseconds) {
        long ms = milliseconds & 1000;
        long s = (milliseconds/1000) % 60;
        long m = (milliseconds/ (1000*60)) % 60;
        return String.format("%02d:%02d:%04d", m,s, ms);
    }

    public java.lang.Long getStart() {
        if (start == null) {
            return null;
        } else {
            return start.getTime();
        }

    }


    //was changed to the long wrapper to return an object that can include null
    public java.lang.Long getStop() {
        if (stop == null) {
            return null;
        } else {
            return stop.getTime();
        }
    }

    public void setStop() {
        stop = new Timestamp(System.currentTimeMillis());
    }


    public String getStartTime() {
        return convertTime(start.getTime());
    }

    public String getStopTime() {
        return convertTime(stop.getTime());
    }

    public String calcDurationTime() {
        long result = stop.getTime() - start.getTime();
        return convertMS(result);
    }

}

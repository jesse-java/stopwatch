package com.naldojesse.com.models;

import java.sql.Timestamp;

public class Timer implements java.io.Serializable{
    private Timestamp start;
    private Timestamp stop;

    public Timer() {
        start = new Timestamp(System.currentTimeMillis());
        stop = null;
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

    public long calcDuration() {
        return stop.getTime() - start.getTime();
    }

}

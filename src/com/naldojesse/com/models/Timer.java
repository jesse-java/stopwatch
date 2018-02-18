package com.naldojesse.com.models;

import java.sql.Timestamp;

public class Timer implements java.io.Serializable{
    private Timestamp start;
    private Timestamp stop;

    public Timer() {
        start = new Timestamp(System.currentTimeMillis());
        stop = null;
    }


    public long getStart() {
        return start.getTime();
    }

    public long getStop() {
        return stop.getTime();
    }

    public void setStop() {
        stop = new Timestamp(System.currentTimeMillis());
    }

    public long calcDuration() {
        return stop.getTime() - start.getTime();
    }

}

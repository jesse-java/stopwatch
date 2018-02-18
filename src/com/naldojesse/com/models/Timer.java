package com.naldojesse.com.models;


public class Timer implements java.io.Serializable{
    private Timer start;
    private Timer stop;

    public Timer() {
        start = null;
        stop = null;
    }

    public Timer(Timer start) {
        this.start = start;
        stop = null;
    }


}

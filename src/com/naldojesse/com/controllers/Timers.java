package com.naldojesse.com.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.naldojesse.com.models.Timer;

import java.util.Objects;

import java.sql.Timestamp;
import java.util.ArrayList;

@WebServlet("/stopwatch")
public class Timers extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //set up session before starting
        boolean currTimerExists = false;
        Timer cTimer = null;
        boolean cTimerStartExists = false;
        boolean cTimerStopExists = false;
        java.lang.Long cTimerStart = null;
        java.lang.Long cTimerStop = null;
        boolean prevTimersExist = false;

        HttpSession session = request.getSession();
        if (session.getAttribute("currTimer") != null) {
            currTimerExists = true;

            cTimer = (Timer) session.getAttribute("currTimer");

            if (cTimer.getStart() != null) {
                cTimerStartExists = true;
                cTimerStart = cTimer.getStart();

            }

            if (cTimer.getStop() != null) {
                cTimerStopExists = true;
                cTimerStop = cTimer.getStop();
            }

        }


        if (session.getAttribute("archivedTimers") != null) {
            prevTimersExist = true;
            prevtimers = (ArrayList<Timer>) session.getAttribute("archivedTimers");
        } else {
            session.setAttribute("archivedTimers", new ArrayList<Timer>());
            prevTim
        }


        // ------------------------------------------------------------------------------------

        //check if user is either accessing page first time, or just refreshing the same page.
        if (request.getParameter("user_action") != null) {


            String action = request.getParameter("user_action");
            System.out.println(action);


            if (Objects.equals(action, "start") == true) {
                //user presses start button
                System.out.println("user pressed start button");

                //if user wants to start new timer, check if user ever pressed stop on last timer, if not stop now and create new timer
                if (cTimer != null) {

                    if (cTimerStop == null) {
                        cTimer.setStop();

                    }
                }


                //start a new timer and set it to currTimer session
                System.out.println("starting new timer!");
                Timer timer = new Timer();
                session.setAttribute("currTimer", timer);

                //send needed attributes to request display
                System.out.println(timer.getStart());

                cTimerStart = timer.getStart();
//                request.setAttribute("startTime", timer.getStart());
//                request.setAttribute("currentTime", System.currentTimeMillis());


            } else if (Objects.equals(action, "stop") == true) {
                //user presses stop button


                if (session.getAttribute("currTimer") != null) {

                    System.out.println("stopping current timer!");
                    Timer timer = (Timer) session.getAttribute("currTimer");

                    if (timer.getStop() != null) {
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }


                    timer.setStop();
                    System.out.println(timer.getStop());


                    request.setAttribute("startTime", timer.getStart());
                    System.out.println(timer.getStop());
                    request.setAttribute("stopTime", timer.getStop());
                    request.setAttribute("currDuration", timer.calcDuration());

                    //clear everything in session
                    session.removeAttribute("currTimer");


                } else {
                    //user presses stop button where there is no current timer in session
                    System.out.println("Stop was pressed without a current timer!");
                }


            } else if (Objects.equals(action, "reset") == true) {
//            reset button was pressed
                System.out.println("resetting current timer!");
                session.invalidate();
            }

        } else {
            if (session.getAttribute("currTimer") != null) {
                Timer currentTimer = (Timer) session.getAttribute("currTimer");

            }

        }


        //test if nullpointer exception or any exception
        request.setAttribute("currStartTime", cTimerStart);
        request.setAttribute("currTime", System.currentTimeMillis());
        request.setAttribute("currRemTime", System.currentTimeMillis() - cTimerStart);

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

}

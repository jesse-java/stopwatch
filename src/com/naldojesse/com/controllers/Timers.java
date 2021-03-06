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

import java.util.ArrayList;

@WebServlet("/stopwatch")
public class Timers extends HttpServlet {

    ArrayList<Timer> prevTimers;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //set up session before starting
        Timer cTimer = null;

        java.lang.Long cTimerStart = null;
        java.lang.Long cTimerStop = null;

        HttpSession session = request.getSession();
        if (session.getAttribute("currTimer") != null) {

            cTimer = (Timer) session.getAttribute("currTimer");

            if (cTimer.getStart() != null) {
                cTimerStart = cTimer.getStart();

            }

            if (cTimer.getStop() != null) {
                cTimerStop = cTimer.getStop();
            }

        }



        if (session.getAttribute("archivedTimers") == null) {
            session.setAttribute("archivedTimers", new ArrayList<Timer>());
        }

        prevTimers = (ArrayList<Timer>) session.getAttribute("archivedTimers");


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
                        prevTimers.add(cTimer);

                    }
                }


                //start a new timer and set it to currTimer session
                System.out.println("starting new timer!");
                Timer timer = new Timer();
                session.setAttribute("currTimer", timer);

                System.out.println(timer.getStart());


                cTimerStart = timer.getStart();



            } else if (Objects.equals(action, "stop") == true) {
                //user presses stop button


                if (cTimer != null) {

                    System.out.println("stopping current timer!");

                    //if current timer in session already has a stop time, then just redirect back to index
                    if (cTimerStop == null) {

                        cTimer.setStop();
                        prevTimers.add(cTimer);
                        System.out.println(cTimer.getStop());

                        //clear currTimer in session
                        session.removeAttribute("currTimer");
                    }


                }


            } else if (Objects.equals(action, "reset") == true) {
//            reset button was pressed
                System.out.println("resetting current timer!");
                session.removeAttribute("archivedTimers");
                session.removeAttribute(("currTimer"));
            }
        }



        request.setAttribute("archivedTimers", session.getAttribute("archivedTimers"));

        request.setAttribute("currTime", Timer.convertTime(System.currentTimeMillis()));

        java.lang.Long runTime;
        if (cTimerStart != null) {
            runTime = System.currentTimeMillis() - cTimerStart;
            request.setAttribute("currStartTime", Timer.convertTime(cTimerStart));
            request.setAttribute("currRunTime", Timer.convertMS(runTime));
        }




        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}

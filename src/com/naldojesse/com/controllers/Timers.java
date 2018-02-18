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

@WebServlet("/stopwatch")
public class Timers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = request.getParameter("user_action");
        System.out.println(action);


        if (Objects.equals(action, "start") == true) {
            System.out.println("starting new timer!");
            Timer timer = new Timer();
            session.setAttribute("currTimer", timer);
            request.setAttribute("startTime", timer.getStart());

            System.out.println(timer.getStart());

        } else if (Objects.equals(action, "stop") == true) {
            System.out.println("stopping current timer!");
            Timer timer = (Timer) session.getAttribute("currTimer");
            timer.setStop();

//            long stop = timer.getStop();
            request.setAttribute("startTime", timer.getStart());
            request.setAttribute("stopTime", timer.getStop());
            request.setAttribute("currDuration", timer.calcDuration());

        }

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
